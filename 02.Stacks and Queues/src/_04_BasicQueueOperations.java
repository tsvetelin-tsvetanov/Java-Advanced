import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

//Play around with a queue.
// You will be given an integer N representing the amount of elements to enqueue (add),
// an integer S representing the amount of elements to dequeue (remove/poll) from the queue
// and finally an integer X, an element that you should check whether is present in the queue.
// If it is print true on the console, if it’s not print the smallest element currently present
// in the queue.
public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        input = scan.nextLine().split("\\s+");
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if(!queue.isEmpty()){
            if (queue.contains(x)){
                System.out.println("true");
            } else {
                Object min = Collections.min(queue);
                System.out.println(min);
            }
        } else {
            System.out.println(0);
        }

    }
}
