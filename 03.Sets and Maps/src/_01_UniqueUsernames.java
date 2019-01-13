import java.util.LinkedHashSet;
import java.util.Scanner;

//Write a simple program that reads from the console a sequence of
// usernames and keeps a collection with only the unique ones.
// Print the collection on the console in order of insertion:
public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        LinkedHashSet<String> names = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            names.add(scan.nextLine());
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
