import java.util.Scanner;
import java.util.TreeMap;

//Write a program that reads some text from the console and
// counts the occurrences of each character in it.
// Print the results in alphabetical (lexicographical) order.
public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();
        TreeMap<Character, Integer> symbolCount = new TreeMap<>();

        for (char c : input) {
            if(!symbolCount.containsKey(c)){
                symbolCount.put(c, 1);
            } else {
                symbolCount.put(c, symbolCount.get(c) + 1);
            }
        }

        for (Character character : symbolCount.keySet()) {
            System.out.printf("%c: %d time/s\n", character, symbolCount.get(character));
        }
    }
}
