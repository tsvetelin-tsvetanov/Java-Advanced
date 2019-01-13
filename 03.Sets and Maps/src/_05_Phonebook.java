import java.util.Scanner;
import java.util.TreeMap;
//Write a program that receives some info from the console about
// people and their phone numbers.
//You are free to choose the manner in which the data is entered;
// each entry should have just one name and one number (both of them
// strings). If you receive a name that already exists in the phonebook,
// simply update its number.
//After filling this simple phonebook, upon receiving the command
// "search", your program should be able to perform a search of a
// contact by name and print her details in format "{name} -> {number}".
// In case the contact isn't found, print "Contact {name} does not exist."

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, String> phonebook = new TreeMap<>();

        while(!input.equals("search")){
            String[] params = input.split("-");
            phonebook.put(params[0], params[1]);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while(!input.equals("stop")){
            if(phonebook.containsKey(input)){
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
            input = scan.nextLine();
        }
    }
}
