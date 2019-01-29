import java.util.*;
import java.util.stream.Collectors;

public class _12_LegendaryFarming {
    //You’ve beaten all the content and the last thing left to accomplish is own a legendary item.
    // However, it’s a tedious process and requires quite a bit of farming. Anyway, you are not too
    // pretentious – any legendary will do. The possible items are:
    //    • Shadowmourne – requires 250 Shards;
    //    • Valanyr – requires 250 Fragments;
    //    • Dragonwrath – requires 250 Motes;
    //Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines
    // of input, such as
    //2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the
    // 250 mark wins the race. At that point, print the corresponding legendary obtained. Then,
    // print the remaining shards, fragments, motes, ordered by quantity in descending order, each
    // on a new line. Finally, print the collected junk items, in alphabetical order.
    //Input
    //    • Each line of input is in format {quantity} {material} {quantity} {material} …
    //    {quantity} {material}
    //Output
    //    • On the first line, print the obtained item in format {Legendary item} obtained!
    //    • On the next three lines, print the remaining key materials in descending order by quantity
    //        ◦ If two key materials have the same quantity, print them in alphabetical order
    //    • On the final several lines, print the junk items in alphabetical order
    //        ◦ All materials are printed in format {material}: {quantity}
    //        ◦ All output should be lowercase, except the first letter of the legendary
    //Constraints
    //    • The quantity-material pairs are between 1 and 25 per line.
    //    • The number of lines is in range [1..10]
    //    • All materials are case-insensitive.
    //    • Allowed working time: 0.25s
    //    • Allowed memory: 16 MB

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        while (!isLegendaryObtained(keyMaterials)) {
            String[] tokens = scan.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                String material = tokens[i + 1];
                Integer quantity = Integer.parseInt(tokens[i]);
                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, 0);
                    }
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
                if (isLegendaryObtained(keyMaterials)) {
                    break;
                }
            }
        }

        checkLegendary(keyMaterials);

        List<Map.Entry<String, Integer>> sortedMaterials =
                new ArrayList<Map.Entry<String, Integer>>(keyMaterials.entrySet());
        Collections.sort(sortedMaterials, new ValueThenKeyComparator<String, Integer>());

        //TODO: Fix order by value then key
        for (Map.Entry<String, Integer> material : sortedMaterials) {
            System.out.printf("%s: %d\n", material.getKey(), material.getValue());
        }

        for (Map.Entry<String, Integer> material : junkMaterials.entrySet()) {
            System.out.printf("%s: %d\n", material.getKey(), material.getValue());
        }

    }

    private static boolean isLegendaryObtained(HashMap<String, Integer> keyMaterials) {
        for (Map.Entry<String, Integer> material : keyMaterials.entrySet()) {
            if (material.getValue() >= 250) {
                return true;
            }
        }
        return false;
    }

    private static void checkLegendary(HashMap<String, Integer> keyMaterials) {
        for (Map.Entry<String, Integer> material : keyMaterials.entrySet()) {
            if (material.getValue() >= 250) {
                if (material.getKey().equals("shards")) {
                    System.out.println("Shadowmourne obtained!");
                    keyMaterials.put(material.getKey(), keyMaterials.get(material.getKey()) - 250);
                } else if (material.getKey().equals("fragments")) {
                    System.out.println("Valanyr obtained!");
                    keyMaterials.put(material.getKey(), keyMaterials.get(material.getKey()) - 250);
                } else {
                    System.out.println("Dragonwrath obtained!");
                    keyMaterials.put(material.getKey(), keyMaterials.get(material.getKey()) - 250);
                }
            }
        }
    }

    public static class ValueThenKeyComparator<K extends Comparable<? super K>,
            V extends Comparable<? super V>>
            implements Comparator<Map.Entry<K, V>> {

        public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
            int cmp1 = a.getValue().compareTo(b.getValue());
            if (cmp1 != 0) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return cmp1;
            }
        }
    }
}