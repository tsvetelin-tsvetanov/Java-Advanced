import java.util.*;

//You are given a sequence of people and for every person what cards
// he draws from the deck. The input will be separate lines in the format:
//{personName}: {PT, PT, PT,… PT}
//Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the
// card and T (S, H, D, C) is the type. The input ends when a "JOKER"
// is drawn. The name can contain any ASCII symbol except ':'.
// The input will always be valid and in the format described, there is
// no need to check it.
//A single person cannot have more than one card with the same power
// and type, if he draws such a card he discards it. The people are
// playing with multiple decks. Each card has a value that is calculated
// by the power multiplied by the type. Powers 2 to 10 have the same
// value and J to A are 11 to 14. Types are mapped to multipliers the
// following way (S -> 4, H-> 3, D -> 2, C -> 1).
//Finally print out the total value each player has in his hand in the format:
//{personName}: {value}
public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        String input = scan.nextLine();
        while(!input.equals("JOKER")){
            String[] values = input.split(": ");
            String[] cards = values[1].split(", ");
            HashSet<String> cardSet = new HashSet<>();
            for (int i = 0; i < cards.length; i++) {
                String card = cards[i];
                cardSet.add(card);
            }
            if(!players.containsKey(values[0])){
                players.put(values[0], cardSet);
            } else {
                players.get(values[0]).addAll(cardSet);
            }

            input = scan.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : players.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), calculateScore(entry.getValue()));
        }

    }

    private static int calculateScore(HashSet<String> cards){
        int score = 0;
        for (String card : cards) {
            char[] cardPair = card.toCharArray();
            int power = getPower(cardPair[0]);
            int type = getType(cardPair[cardPair.length - 1]);
            score += (power * type);
        }
        return score;
    }

    private static int getPower(char p){
        switch (p){
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '1':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return 0;
        }
    }

    private static int getType(char t){
        switch (t){
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }
}
