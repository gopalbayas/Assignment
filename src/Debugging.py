# task 3 Debugging
""" Given below is a Bash / Python script that performs following computation on an integer input (n):
If n is less than 10: Calculate its Square
Example: 4 => 16
If n is between 10 and 20: Calculate the factorial of (n-10)
Example: 15 => 120
If n is greater than 20: Calculate the sum of all integers between 1 and (n-20)
Example: 25 => 15

The task is to identify the bugs in the script, fix them and share the new script.
 Only one of the two scripts required Bash or Python.
 Hint: You can correct the script by only changing less than 5 characters."""
#Question code
"""def compute(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
        for i in range(1, n-10):
            out *= i
    else:
        lim = n - 20
        out = lim * lim
        out = out - lim
        out = out / 2
    print(out)

n = int(input("Enter an integer: "))
compute(n)"""

 # Answer code
"""def compute(n):
    if n < 10 :
        out = n ** 2
    elif n < 20 :
        out=1
        for i in range (1,n-9) :      # change1. from n-10 to n-9
        out *=i
    else:
        lim n -20
        out = lim *(lim +1) // 2       # change2. (lim * lim) to (lim *(lim+1))
        print(out)
        
        n = int(input("Enter an integer: "))
        compute(n) """