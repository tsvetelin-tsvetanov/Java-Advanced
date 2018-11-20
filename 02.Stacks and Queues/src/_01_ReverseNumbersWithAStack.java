//Problem 1. Reverse Numbers with a Stack
//Write a program that reads N integers from the console and reverses them using a stack.
//Use the Stack<Integer> class.
//Just put the input numbers in the stack and pop them.

import java.util.Scanner;
import java.util.Stack;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputToInt = input.split("\\s+");
        int[] numbers = new int[inputToInt.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputToInt[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            stack.add(number);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
