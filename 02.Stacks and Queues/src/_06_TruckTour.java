//Suppose there is a circle. There are N petrol pumps on that circle. Petrol pumps are numbered 0 to (N−1) 
// (both inclusive). You have two pieces of information corresponding to each of the petrol pump:
// (1) the amount of petrol that particular petrol pump will give, and
// (2) the distance from that petrol pump to the next petrol pump.
//Initially, you have a tank of infinite capacity carrying no petrol.
//You can start the tour at any of the petrol pumps. Calculate the first point from where the truck
// will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps.
// The truck will move one kilometer for each liter of the petrol.
//Input Format: The first line will contain the value of N.
//The next N lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump
// will give and the distance between that petrol pump and the next petrol pump.
//Output Format: An integer which will be the smallest index of the petrol pump from which we can start
// the tour.
//Constraints:
//1 ≤ N ≤ 1000001
//1 ≤ Amount of petrol, Distance ≤ 1000000000

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_TruckTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = new Integer(scan.nextLine()); //add number of fuel stations
        TreeMap<Integer, ArrayList<Integer>> fuelStations = new TreeMap<>();

        //add fuel stations
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(scan.nextInt()); //read amount of petrol
            values.add(scan.nextInt()); //read distance
            fuelStations.put(i, values);
        }

        int indexOfStartingPetrolStation = -1;
        for (int i = 0; i < n; i++) {
            if(calculateTrip(i, fuelStations, n)){
                indexOfStartingPetrolStation = i;
                break;
            }
        }

        if(indexOfStartingPetrolStation >= 0){
            System.out.println(indexOfStartingPetrolStation);
        } else {
            System.out.println("The truck can't complete the circle with the given fuel stations.");
        }
    }

    static boolean calculateTrip(int startingPoint,  TreeMap<Integer, ArrayList<Integer>> fuelStations,
                                 int numberOfFuelStations){
        int truckFuel = 0;
        //load fuel from the starting fuel station
        truckFuel += fuelStations.get(startingPoint).get(0);

        int currentFuelStation = startingPoint;
        for (int i = 0; i < numberOfFuelStations; i++) {
            //deduct the fuel needed to reach next fuel station
             truckFuel -= fuelStations.get(currentFuelStation).get(1);
             if(truckFuel < 0){
                 return false;
             }
             //update current fuel station
            currentFuelStation++;
             if(currentFuelStation == numberOfFuelStations){
                 currentFuelStation = 0;
             }
            //load fuel from the next fuel station
            truckFuel += fuelStations.get(currentFuelStation).get(0);
        }

        if(truckFuel >= 0){
            return true;
        } else {
            return false;
        }
    }
}
