import java.util.*;

//Given a sequence consisting of parentheses, determine whether the expression is balanced.
// A sequence of parentheses is balanced if every open parenthesis can be paired uniquely
// with a closed parenthesis that occurs after the former. Also, the interval between them must
// be balanced. You will be given three types of parentheses: (, {, and [.
//{[()]} - This is a balanced parenthesis.
//{[(])} - This is not a balanced parenthesis.
//Input Format: Each input consists of a single line, S, the sequence of parentheses.
//Constraints: 
//1 ≤ lens ≤ 1000, where lens is the length of the sequence. 
//Each character of the sequence will be one of {, }, (, ), [, ].
//Output Format: For each test case, print on a new line "YES" if the parentheses are balanced.
// Otherwise, print "NO". Do not print the quotes.
public class _07_BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();

        Queue<Character> leftSide = new ArrayDeque<>();
        Stack<Character> rightSide = new Stack<>();

        for (int i = 0; i < input.length ; i++) {
            if(i < input.length/2){
                leftSide.add(input[i]);
            } else {
                rightSide.push(input[i]);
            }
        }

        if(checkBalance(leftSide, rightSide)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static boolean checkBalance(Queue<Character> leftSide, Stack<Character> rightSide){
        for (Character character : leftSide) {
            switch (character){
                case '{':
                    if(!(rightSide.pop().equals('}')))
                        return false;
                    break;
                case '[':
                    if(!(rightSide.pop().equals(']')))
                        return false;
                    break;
                case '(':
                    if(!(rightSide.pop().equals(')')))
                        return false;
                    break;
            }
        }
        return true;
    }
}
