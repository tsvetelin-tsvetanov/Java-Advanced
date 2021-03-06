//You are given an empty text. Your task is to implement 4 commands related to
// manipulating the text
//    • 1 someString - appends someString to the end of the text
//    • 2 count - erases the last count elements from the text
//    • 3 index - returns the element at position index from the text
//    • 4 - undoes the last not undone command of type 1 / 2 and returns the text to the
//    state before that operation
//Input format: The first line contains n, the number of operations.
//Each of the following n lines contains the name of the operation followed by the command
// argument, if any, separated by space in the following format CommandName Argument.
//For example:
//3
//1 abc
//2 2
//4
//
//Output Format: For each operation of type 3 print a single line with the returned character
// of that operation.
//Constraints:
//1 ≤ N ≤ 105
//The length of the text will not exceed 1000000
//All input characters are English letters.
//It is guaranteed that the sequence of input operation is possible to perform

import java.util.Scanner;
import java.util.Stack;

public class _10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            switch (input[0]){
                case "1":
                    if(stack.empty()){
                        stack.push(input[1]);
                    } else {
                        stack.push(stack.peek().concat(input[1]));
                    }
                    break;
                case "2":
                    if(!stack.empty()){
                        stack.push(stack.peek().substring(0,
                                stack.peek().length() - Integer.parseInt(input[1])));
                    }
                    break;
                case "3":
                    System.out.println(stack.peek().charAt(Integer.parseInt(input[1]) - 1));
                    break;
                case "4":
                    stack.pop();
                    break;
            }
        }
    }
}
