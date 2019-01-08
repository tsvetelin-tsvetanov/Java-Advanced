//The Fibonacci sequence is quite a famous sequence of numbers. Each member of the sequence
// is calculated from the sum of the two previous elements. The first two elements are 1, 1.
// Therefore the sequence goes as 1, 1, 2, 3, 5, 8, 13, 21, 34…
//The following sequence can be generated with an array, but that’s easy, so your task is to
// implement recursively.
//So if the function getFibonacci(n) returns the n’th Fibonacci number we can express it
// using getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2)
//However, this will never end and in a few seconds a StackOverflow Exception is thrown.
// In order for the recursion to stop it has to have a “bottom”. The bottom of the recursion
// is getFibonacci(1) should return 1 and getFibonacci(0) should return 1.
//Input Format: On the only line in the input the user should enter the wanted Fibonacci number.
//Output Format: The output should be the n’th Fibonacci number counting from 0
//Constraints:
//1 ≤ N ≤ 49

import java.util.Scanner;

public class _08_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fibonacciIndex = Integer.parseInt(scan.nextLine());
        System.out.println(getFibonacci(fibonacciIndex));

    }

    static long getFibonacci(int n){
        if(n == 0 || n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}
