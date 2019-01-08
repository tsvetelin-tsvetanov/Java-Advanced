import java.util.Scanner;
import java.util.Stack;

//There is another way of calculating the Fibonacci sequence using a stack.
// It is non recursive, so it does not make any unnecessary calculations.
// Try implementing it. First push 1 and 1 and them use popping peeking and pushing to
// generate every consecutive number.
public class _09_StackFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Stack<Long> fibonacciStack = new Stack<>();

        fibonacciStack.push(1l);
        fibonacciStack.push(1l);

        for (int i = 1; i < n; i++) {
            long previousFib = fibonacciStack.pop();
            long currentFib = previousFib + fibonacciStack.peek();
            fibonacciStack.push(previousFib);
            fibonacciStack.push(currentFib);
        }

        System.out.println(fibonacciStack.peek());
    }
}
