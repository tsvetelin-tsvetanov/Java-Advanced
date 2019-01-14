import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
//You are given a sequence of strings, each on a new line, unitll you receive “stop” command.
// First string is a name of a person. On the second line you receive his email.
// Your task is to collect their names and emails, and remove emails whose domain ends with "us"
// or "uk" (case insensitive). Print:
//{name} – > {email}

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, String> emails = new TreeMap<>();

        String input = scan.nextLine();
        while(!input.equals("stop")){
            String name = input;
            String email = scan.nextLine();

            emails.put(name, email);

            input = scan.nextLine();
        }

        emails.values().removeIf(e -> e.toLowerCase().contains("uk"));
        emails.values().removeIf(e -> e.toLowerCase().contains("us"));

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}
