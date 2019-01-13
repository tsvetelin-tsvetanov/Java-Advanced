import java.util.HashSet;
import java.util.Scanner;

//On the first line you are given the length of two sets n and m.
// On the next n + m lines there are n numbers that are in the first
// set and m numbers that are in the second one. Find all non-repeating
// element that appears in both of them, and print them at the console:
//Set with length n = 4: {1, 3, 5, 7}
//Set with length m = 3: {3, 4, 5}
//Set that contains all repeating elements -> {3, 5}
public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<Integer> nSet = new HashSet<>();
        HashSet<Integer> mSet = new HashSet<>();

        for (int i = 0; i < n + m; i++) {
            if(i < n){
                nSet.add(Integer.parseInt(scan.nextLine()));
            } else {
                mSet.add(Integer.parseInt(scan.nextLine()));
            }
        }

        for (Integer integer : nSet) {
            if (mSet.contains(integer)){
                System.out.print(integer + " ");
            }
        }
    }
}
