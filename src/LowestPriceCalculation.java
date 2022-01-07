/*
Dhruv K. Saligram
10/13/18
This class finds the lowest prices in a list
*/
package videogameapplication;
//Imports below:
import java.util.ArrayList;
//Creating class below:
public class LowestPriceCalculation {
    //Creating method for finding lowest price with an int array below:
    public int lowestPrice (int[] numbers) {
        int cheapest = 2147483647;
        //Cycling through all numbers to find smallest value below:
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] < cheapest) {
                cheapest = numbers[i];
            }
        }
        //Returning smallest number below:
        return cheapest;
    }
    //Creating method for finding lowest price with an integer array list below:
    public int finalLowestCalculation (ArrayList<Integer> prices) {
        int cheapest = 2147483647;
        int[] pricesIntArray = new int[prices.size()];
        //Setting array equal to array list below:
        for (int i=0; i<prices.size(); i++) {
            pricesIntArray[i] = prices.get(i).intValue();
        }
        //Cycling through all numbers to find smallest value below:
        for (int z=0; z<pricesIntArray.length; z++) {
            if (pricesIntArray[z] < cheapest) {
                cheapest = pricesIntArray[z];
            }
        }
        //Returning smallest number below:
        return cheapest;
    }
}