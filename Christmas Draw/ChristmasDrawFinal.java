// Imports utility classes
import java.util.*;


// Public class of my Christmas Draw
public class ChristmasDraw {
	
    // Public main method, contains original couples ArrayLists, draw 1 and 2 arrayLists. 
    // Also the calls to random pair generator function, which then prints the values to the console via println statements.
    public static void main(String args[]) {
        
        // Initialise a counter for the while loop
        int count = 0;

        // While loop to loop over year1 and year2, until it finds a good pairing
        while (count < 1)
        {
            // Initial ArrayList containing all the possible individuals in a couple.
             ArrayList<String> couples = new ArrayList<>(Arrays.asList("x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"));

             // Print statement which specifies in the console that it is the first years draw.
             System.out.println("Year 1 draw: ");

             // This then initialises a new ArrayList to one instance of the 'makePairs' function.
             ArrayList<String> drawYearOne = makePairs(couples);

             // This print statement ensures that there is a space to keep the display neat.
             System.out.println();

             // Print statement which specifies in the console that it is the seconds years draw.
             System.out.println("Year 2 draw: ");
             // This then initialises a new ArrayList to one instance of the 'makePairs' function.
             ArrayList<String> drawYearTwo = makePairs(couples);

            // If statement to check if any indexes in an array are equal
            if (checker() == true)
            {
                // Continue back to loop if there are matches
                continue;
            }

            // Increment the counter to end the while loop
            count++;
        }

	}


    // Public function makePairs, which returns the type ArrayList and has a parameter of type ArrayList.
	public static ArrayList<String> makePairs(ArrayList<String> arrayL) {
		
        // Shuffles (randomises) arrayL. This enusres uniqueness.
		Collections.shuffle(arrayL);
        // Creates new array list to store randomised arrayL.
		ArrayList<String> buyingFor = new ArrayList<String>();
        // Adds elements from new arrayL and adds them to the created ArrayList.
		buyingFor.addAll(arrayL);

		// Shuffles (randomises) arrayL. This enusres uniqueness.
        Collections.shuffle(arrayL);
        // Creates new array list to store randomised arrayL.
        ArrayList<String> boughtFor = new ArrayList<String>();
        // Adds elements from new arrayL and adds them to the created ArrayList.
        boughtFor.addAll(arrayL);

        // ArrayList containing pairs which aren't allowed
        ArrayList<String> pairings = new ArrayList<>(Arrays.asList("x1y1", "x2y2", "x3y3", "x4y4", "x5y5", "y1x1", "y2x1", "y3x3", "y4x4", "y5x5"));

        // For loop to check whether any indexes of buyingFor are the same as boughtFor. If they are, continue to for loop again.
        // Else, the loop will break
        for (int i = 0; i < arrayL.size(); i++)
        {
        	// If statement to check if indexes are the same
            if (buyingFor.get(i) == boughtFor.get(i))
        	{
        		// If the condition for 'if' is met, then carry out a 'continue'
                continue;
        	}
        }

        // For loop which uses arrayL's length (always 10 because of 10 elements), in order to iterate through the two new ArrayLists
        // The print statement then prints indexes for both arrays, which leads to 5 couples receiving and buying gifts.
        for (int j = 0; j < arrayL.size(); j++)
        {
        	// Prints both the randomised arrays with a string in the middle.
            System.out.println(buyingFor.get(j) + " buys for " + boughtFor.get(j));
        }


        // Return statement which returns the randomised arrayList arrayL
		return arrayL;
	}


    // Function to check if the not allowed pairs are within the randomly generated pairs
    public static boolean checker() {
        // Array list to keep track of the paired arrays 
        ArrayList<String> pairArray = new ArrayList<String>();
        // Array list containing couples
        ArrayList<String> couples = new ArrayList<>(Arrays.asList("x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"));
        // Array list containing not allowed pairs
        ArrayList<String> notAllowed = new ArrayList<>(Arrays.asList("x1y1", "x2y2", "x3y3", "x4y4", "x5y5", "y1x1", "y2x1", "y3x3", "y4x4", "y5x5"));
        // for loops for going through randomised arrays and cocatenating them 
        for (int i = 0; i < 10; i++)
        {
            // variable for storing the pairs 
            String pair = couples.get(i);
            // adds the pair to arrayList
            pairArray.add(pair);
            // For loop to there are pairs in the created array which are not allowed
            for (int j = 0; j < 10; j++)
            {
                if(pair == notAllowed.get(i))
                    // Return statement returing the boolean value true
                    return true;
            } 

        }
        // Return statement returing the boolean value false
        return false;
    }


}