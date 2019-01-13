import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

//You are given an n number of chemical compounds.
// You need to keep track of all chemical elements used in the
// compounds and at the end print all unique ones in ascending order:
public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        TreeSet<String> chemicals = new TreeSet<>();

        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split(" ");
            Collections.addAll(chemicals, row);
        }

        for (String chemical : chemicals) {
            System.out.print(chemical + " ");
        }
    }
}
