//task 2
/*
task 2 - Task-2
Evaluate multiple mathematical expressions at once using a Web API

Problem Statement
Write a program that accepts multiple mathematical expressions in bulk and evaluates each of them using any public Web API available.
 The program should display the result of each expression on the console. Let’s assume that the API only supports 50 requests per second per client
  whereas your application is expected to evaluate at least 500 expressions per second. Also, the user may initiate more concurrent requests than your application can handle. Suggest an approach to handle this along with the reasoning and implementation of the same.
Rules
No expressions should be evaluated in the code. All evaluations should be using the Web API.
You can assume different expressions/operators that are compatible with the API you choose.
Example: Some API might use ^ operator for power some might use pow()
Example
Input (every line is an expression, evaluate when “end” is provided as an expression)
2 * 4 * 4
5 / (7 - 5)
sqrt(5^2 - 4^2)
sqrt(-3^2 - 4^2)
end
Output
2 * 4 * 4 => 32
5 / (7 - 5) => 2.5
sqrt(5^2 - 4^2) => 3
sqrt(-3^2 - 4^2) = 5i
 */

// Answer_code-->

// Instruction
/*
Ensure we are using java 11 or advance version. here we are using 'HttpClient' for make Http request to a web API.
save the file name as = ' ExpressionEvaluator.java '
compile the code using 'javac ExpressionEvaluator.java '
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ExpressionEvaluator {
    public static String API_URL = "https://api.mathjs.org/v4/";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            while(true){
                System.out.println("Enter Expression");
                String expression = scanner.nextLine().trim();
                if(expression.equals("end")){
                    break ;
                }
                String result = evaluateExpression(expression);
                System.out.println(expression +" => "+ result);
            }
        }
        finally {
            scanner.close();
        }
    }
    public static String evaluateExpression(String expression){
        try{
            HttpClient client = HttpClient.newHttpClient();
            // replace space with "%20" to form URL
            String urlExpression = expression.replaceAll(" ","%20");

            URI uri = URI.create(API_URL+"?expr="+urlExpression);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error evaluating expression";
        }

    }
}


