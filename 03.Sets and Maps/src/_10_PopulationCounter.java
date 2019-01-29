import java.util.*;

//So many people! It’s hard to count them all. But that’s your job as a statistician. You get raw
// data for a given city and you need to aggregate it.
//On each input line you’ll be given data in format: "city|country|population". There will be no
// redundant whitespaces anywhere in the input. Aggregate the data by country and by city and print
// it on the console. For each country, print its total population and on separate lines the data
// for each of its cities. Countries should be ordered by their total population in descending order
// and within each country, the cities should be ordered by the same criterion. If two
// countries/cities have the same population, keep them in the order in which they were entered.
// Check out the examples; follow the output format strictly!
//Input
//    • The input data should be read from the console.
//    • It consists of a variable number of lines and ends when the command "report" is received.
//    • The input data will always be valid and in the format described. There is no need to check
//    it explicitly.
//Output
//    • The output should be printed on the console.
//    • Print the aggregated data for each country and city in the format shown below.
//Constraints
//    • The name of the city, country and the population count will be separated from each other
//    by a pipe ('|').
//    • The number of input lines will be in the range [2 … 50].
//    • A city-country pair will not be repeated.
//    • The population count of each city will be an integer in the range [0 … 2 000 000 000].
//    • Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("report")) {
            String[] params = input.split("\\|");
            String city = params[0];
            String country = params[1];
            Long population = Long.parseLong(params[2]);

            if (!populationMap.containsKey(country)) {
                populationMap.put(country, new LinkedHashMap<>());
                populationMap.get(country).put(city, population);
            } else {
                if (!populationMap.get(country).containsKey(city)) {
                    populationMap.get(country).put(city, population);
                }
                input = scan.nextLine();
            }
        }

    }

}
