import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
//Marian is a famous system administrator. The person to overcome the security of his servers has
// not yet been born. However, there is a new type of threat where users flood the server with
// messages and are hard to be detected since they change their IP address all the time. Well,
// Marian is a system administrator and is not so into programming. Therefore, he needs a skillful
// programmer to track the user logs of his servers. You are the chosen one to help him!
//You are given an input in the format:
//IP=(IP.Address) message=(A&sample&message) user=(username)
//Your task is to parse the ip and the username from the input and for every user, you have to
// display every ip from which the corresponding user has sent a message and the count of the
// messages sent with the corresponding ip. In the output, the usernames must be sorted alphabetically
// while their IP addresses should be displayed in the order of their first appearance. The output
// should be in the following format:
//username:
//IP => count, IP => count.
//For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer,
// you have to get the username destroyer and the IP 192.23.30.40 and display it in the following
// format:
//destroyer:
//192.23.30.40 => 1.
//The username destroyer has sent a message from ip 192.23.30.40 once.
//Check the examples below. They will further clarify the assignment.
//Input:
//The input comes from the console as varying number of lines. You have to parse every command
// until the command that follows is end. The input will be in the format displayed above,
// there is no need to check it explicitly.
//Output
//For every user found, you have to display each log in the format:
//username:
//IP => count, IP => count…
//The IP addresses must be split with a comma, and each line of IP addresses must end with a dot.
//Constraints
//    • The number of commands will be in the range [1..50]
//    • The IP addresses will be in the format of either IPv4 or IPv6.
//    • The messages will be in the format: This&is&a&message
//    • The username will be a string with length in the range [3..50]
//    • Time limit: 0.3 sec. Memory limit: 16 MB.

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        String input = scan.nextLine();
        while(!input.equals("end")){
            String[] values = input.split(" ");
            String ip = values[0].substring(3, values[0].length());
            String user = values[2].substring(5, values[2].length());

            if(logs.containsKey(user)){
                if(logs.get(user).containsKey(ip)){
                    logs.get(user).put(ip, logs.get(user).get(ip) + 1);
                } else {
                    logs.get(user).put(ip,1);
                }
            } else {
                logs.put(user, new LinkedHashMap<>());
                logs.get(user).put(ip, 1);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> name : logs.entrySet()) {
            System.out.printf("%s:\n", name.getKey());
            Map<String, Integer> childMap = name.getValue();
            for (Map.Entry<String, Integer> ip : childMap.entrySet()) {
                System.out.printf("%s => %d\n", ip.getKey(), ip.getValue());
            }
        }
    }
}
