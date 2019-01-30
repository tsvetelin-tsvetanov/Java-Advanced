import java.util.*;

public class _14_DragonArmy {
    //Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is
    // no exclusion to this rule. His favorite units in the game are all types of dragons – black,
    // red, gold, azure etc… He likes them so much that he gives them names and keeps logs of their
    // stats: damage, health and armor. The process of aggregating all the data is quite tedious, so
    // he would like to have a program doing it. Since he is no programmer, it’s your task to help him
    //You need to categorize dragons by their type. For each dragon, identified by name, keep
    // information about his stats. Type is preserved as in the order of input, but dragons are
    // sorted alphabetically by name. For each type, you should also print the average damage, health
    // and armor of the dragons. For each dragon, print his own stats.
    //There may be missing stats in the input, though. If a stat is missing you should assign it
    // default values. Default values are as follows: health 250, damage 45, and armor 10. Missing
    // stat will be marked by null.
    //The input is in the following format {type} {name} {damage} {health} {armor}. Any of the
    // integers may be assigned null value. See the examples below for better understanding of your
    // task.
    //If the same dragon is added a second time, the new stats should overwrite the previous ones.
    // Two dragons are considered equal if they match by both name and type.
    //Input
    //    • On the first line, you are given number N -> the number of dragons to follow
    //    • On the next N lines you are given input in the above described format. There will be
    //    single space separating each element.
    //Output
    //    • Print the aggregated data on the console
    //    • For each type, print average stats of its dragons in format
    //    {Type}::({damage}/{health}/{armor})
    //    • Damage, health and armor should be rounded to two digits after the decimal separator
    //    • For each dragon, print its stats in format -
    //    {Name} -> damage: {damage}, health: {health}, armor: {armor}
    //Constraints
    //    • N is in range [1…100]
    //    • The dragon type and name are one word only, starting with capital letter.
    //    • Damage health and armor are integers in range [0 … 100000] or null

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = 0;
            if(tokens[2].equals("null")){
                damage = 45;
            } else {
                damage = Integer.parseInt(tokens[2]);
            }

            int health = 0;
            if(tokens[3].equals("null")){
                health = 250;
            } else {
                health = Integer.parseInt(tokens[3]);
            }

            int armor = 0;
            if(tokens[4].equals("null")){
                armor = 10;
            } else {
                armor = Integer.parseInt(tokens[4]);
            }

            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>());
            }

            dragons.get(type).put(name, new ArrayList<>());
            dragons.get(type).get(name).add(damage);
            dragons.get(type).get(name).add(health);
            dragons.get(type).get(name).add(armor);
        }

        for (Map.Entry<String, TreeMap<String, ArrayList<Integer>>> dragonType : dragons.entrySet()) {
            float totalDamage = 0;
            float totalHealth = 0;
            float totalArmor = 0;
            int count = 0;
            String output = "";

            for(Map.Entry<String, ArrayList<Integer>> dragon : dragonType.getValue().entrySet()){
                output += "-" + dragon.getKey() + " -> damage: " + dragon.getValue().get(0) +
                     ", health: " + dragon.getValue().get(1) +
                        ", armor: " + dragon.getValue().get(2) + "\n";
                totalDamage += dragon.getValue().get(0);
                totalHealth += dragon.getValue().get(1);
                totalArmor += dragon.getValue().get(2);
                count++;
            }

            totalDamage /= count;
            totalHealth /= count;
            totalArmor /= count;

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", dragonType.getKey(), totalDamage,
                    totalHealth, totalArmor);
            System.out.println(output.substring(0, output.length() - 1));
        }
    }

}
