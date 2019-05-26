import java.util.*;

public class ChristmasDraw {
	public static void main(String args[]) {
                 ArrayList<String> couples = new ArrayList<>(Arrays.asList("x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"));
		 System.out.println("Year 1 draw: ");
		 ArrayList<String> drawYearOne = makePairs(couples);

		 System.out.println();
		 
		 System.out.println("Year 2 draw: ");
		 ArrayList<String> drawYearTwo = makePairs(couples);


	}


	public static ArrayList<String> makePairs(ArrayList<String> arrayL) {
		// Shuffle couple array and add them a new array list
		Collections.shuffle(arrayL);
		ArrayList<String> buyingFor = new ArrayList<String>();
		buyingFor.addAll(arrayL);

		// Shuffle couple array again and add them to another new array list
                Collections.shuffle(arrayL);
                ArrayList<String> boughtFor = new ArrayList<String>();
                boughtFor.addAll(arrayL);

        // Iterate through loop and check if any index of buyingFor is equal to index of boughtFor
        for (int i = 0; i < arrayL.size(); i++)
        {
        	if (buyingFor.get(i) == boughtFor.get(i))
        	{
        		break;
        	}
        	else 
        	{
        		continue;
        	}
        }

        // Loop to print the arrays
        for (int j = 0; j < arrayL.size(); j++)
        {
        	System.out.println(buyingFor.get(j) + " buys for " + boughtFor.get(j));
        }



		return arrayL;
	}





}