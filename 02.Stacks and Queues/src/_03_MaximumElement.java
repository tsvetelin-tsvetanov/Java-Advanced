import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

//You have an empty sequence, and you will be given N queries.
//Each query is one of these three types:
//1 x - Push the element x into the stack.
//2    - Delete the element present at the top of the stack.
//3    - Print the maximum element in the stack.
//Input Format: The first line of input contains an integer, N.
//The next N lines each contain an above mentioned query. 
//(It is guaranteed that each query is valid.)
//Output Format: For each type 3 query, print the maximum element in the stack on a new line.
//Constraints:
//1 ≤ N ≤ 105 
//1 ≤ x ≤ 109
//1 ≤ type ≤ 3
public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = new Integer(scan.nextLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int command = new Integer(scan.next());
            switch (command) {
                case 1:
                    stack.push(new Integer(scan.next()));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Object max = Collections.max(stack);
                    System.out.println(max);
                    break;
            }
            scan.nextLine();
        }
    }
}
