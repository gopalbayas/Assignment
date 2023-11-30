import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// task 1
/*
Simulation of an Event that Follows Given Biasness

Problem Statement: Write a program that accepts a map of all possible outcomes of an event along with their probabilities and
every occurrence of the event would generate outcomes based on the given probabilities.
This could be seen as a generalization of events like rolling of a dice (could be biased) or flipping of a coin (could be biased).
Examples
Rolling of a six-faced biased dice
Input: [ {1, 10}, {2, 30}, {3, 15}, {4, 15}, {5, 30}, {6, 0} ]
Flipping of a coin
Input [ {“Head”: 35}, {“Tail”: 65} ]
Rules
Input: 1.Probabilities given are as integers and percentages.
 */
// Answer code -->
//Instruction
/*
1. Save thecode in a file as'EventSimulation.java'.
2. Run the compiled code using 'java EventSimulation'.
*/
public class EventSimulation {

    public static void main(String[] args) {
        HashMap<Integer,Integer> eventOutcomes = new HashMap<>();
        // Assume Head , Tail Example - [1:35,2:65]  1  indicate Head , 2 indiacate Tail
        eventOutcomes.put(1,35);
        eventOutcomes.put(2,65);
        SimulateEvent(eventOutcomes);
    }

    public static void SimulateEvent(Map<Integer,Integer>outcomes){
        int  TotalCounts = 1000 ;
       Map<Integer,Integer> outcomeCounts = new HashMap<>(); // Creating map for Outcome and probability

        for (int outcome : outcomes.keySet()) {
            outcomeCounts.put(outcome, 0);
        }
        Random random = new Random();

        for(int i =0 ; i < TotalCounts ; i++){
            int randomNumber = random.nextInt(100)+1;   // Generating random number from 0 to 100 to stimulate probability
            // Determining Outcomes based on Probabilities
            int  cumulativeProbability = 0;
            int outcome ;
            int probability ;
             for(Map.Entry<Integer,Integer> entry : outcomes.entrySet()) {
                 outcome = entry.getKey();
                 probability = entry.getValue();

                 cumulativeProbability += probability;
                 if (randomNumber <= cumulativeProbability) {
                     outcomeCounts.put(outcome, outcomeCounts.get(outcome) + 1);
                     break;
                 }
             }
        }
             // printing result
        for(Map.Entry<Integer,Integer> entry : outcomeCounts.entrySet()){
            int outcome = entry.getKey();
            int probability = entry.getValue();
            System.out.println(outcome + probability);
        }
    }
}
