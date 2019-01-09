import java.util.ArrayList;
import java.util.Scanner;

//You are given N plants in a garden. Each of these plants has been added with some amount
// of pesticide. After each day, if any plant has more pesticide than the plant at its left,
// being weaker(more GMO) than the left one, it dies. You are given the initial values of the
// pesticide and position of each plant. Print the number of days after which no plant dies,
// i.e. the time after which there are no plants with more pesticide content than the plant to
// their left.
//Input Format: The input consists of an integer N representing the number of plants.
// The next single line consists of N integers where every integer represents the position and
// amount of pesticides of each plant.
//Constraints: 1 ≤ N ≤ 100000
//Pesticides amount on a plant is between 0 and 1000000000
//Output Format: Output a single value equal to the number of days after which no plants die
//Examples
public class _11_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Long> plants = new ArrayList<>();

        int numberOfPlants = Integer.parseInt(scan.nextLine());
        String[] plantsAsStr = scan.nextLine().split(" ");

        for (int i = 0; i < plantsAsStr.length; i++) {
            plants.add(Long.parseLong(plantsAsStr[i]));
        }

        int numberOfDays = 0;
        ArrayList<Integer> indexesToRemove = new ArrayList<>();
        boolean allPlantsSurvived = false;

        while(!allPlantsSurvived){
            for (int i = 1; i < plants.size(); i++) {
                if (plants.get(i - 1) < plants.get(i)) {
                    indexesToRemove.add(i);
                }
            }

            if(!indexesToRemove.isEmpty()){
                int changeInIndex = 0;
                for (int index : indexesToRemove) {
                    plants.remove(index - changeInIndex);
                    changeInIndex++;
                }
                indexesToRemove = new ArrayList<>();
                numberOfDays++;
            } else {
                allPlantsSurvived = true;
            }
        }

        System.out.println(numberOfDays);

    }

}
