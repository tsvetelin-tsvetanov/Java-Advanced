import java.util.Scanner;
import java.util.Stack;

//Play around with a stack. You will be given an integer N representing the amount of elements
// to push onto the stack, an integer S representing the amount of elements to pop
// from the stack and finally an integer X, an element that you should check whether is present
// in the stack. If it is print true on the console, if it’s not print the smallest element
// currently present in the stack.
//Input Format: On the first line you will be given N, S and X separated by a single space.
// On the next line you will be given N amount of integers.
//Output Format: On a single line print either true if X is present in the stack otherwise
// print smallest element in the stack. If the stack is empty print 0.
public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        input = scan.nextLine().split("\\s+");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < s; i++) {
           stack.pop();
        }

        if(stack.contains(x)){
            System.out.println("true");
        } else {
            int min = stack.peek();
            while(!stack.isEmpty()){
                if(min > stack.peek()){
                    min = stack.peek();
                }
                stack.pop();
            }
            System.out.println(min);
        }
    }
}
