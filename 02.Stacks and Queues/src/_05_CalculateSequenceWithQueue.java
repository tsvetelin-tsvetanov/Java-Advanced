import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//We are given the following sequence of numbers:
//    • S1 = N
//    • S2 = S1 + 1
//    • S3 = 2*S1 + 1
//    • S4 = S1 + 2
//    • S5 = S2 + 1
//    • S6 = 2*S2 + 1
//    • S7 = S2 + 2
//    • …
//Using the ArrayDeque<E> class, write a program to print its first 50 members for given N.
public class _05_CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());
        queue.addFirst(n);

        for (int i = 0; i < 50; i++) {
            int current = queue.removeFirst();
            System.out.print(current + " ");

            int s1 = current + 1;
            int s2 = 2 * current + 1;
            int s3 = current + 2;

            queue.add(s1);
            queue.add(s2);
            queue.add(s3);
        }
    }
}
