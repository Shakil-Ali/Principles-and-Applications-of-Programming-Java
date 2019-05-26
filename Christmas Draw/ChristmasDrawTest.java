// Imports utility classes
import java.util.*;

// Public class of my Christmas Draw
public class ChristmasDrawTest {
	
    

    // Public main method, contains original couples ArrayLists, draw 1 and 2 arrayLists. 
    // Also the calls to random pair generator function, which then prints the values to the console via println statements.
    public static void main(String args[]) {
        
            int count = 0; 

            ArrayList<String> couples = new ArrayList<>(Arrays.asList("x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"));
            ArrayList<String> pairings = new ArrayList<>(Arrays.asList("x1y1", "x2y2", "x3y3", "x4y4", "x5y5", "y1x1", "y2x2", "y3x3", "y4x4", "y5x5"));
            ArrayList<Integer> pairArray = new ArrayList<Integer>(10);
            ArrayList<String> pair = new ArrayList<String>(10);

            while (count < 1)  
            {       
             // Initial ArrayList containing all the possible individuals in a couple.
             

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



            if (pairChecker() == true)
            {
                System.out.println("This loops 4eva");
                continue;
            }

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


        // For loop to check whether any indexes of buyingFor are the same as boughtFor. If they are, continue to for loop again.
        // Else, the loop will break
        for (int i = 0; i < arrayL.size(); i++)
        {
        	if (buyingFor.get(i) == boughtFor.get(i))
        	{
        		// If the condition for 'if' is met, then carry out a 'continue'
                continue;
        	}
            else
            {
                break;
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


    public static boolean pairChecker()
    {
        for (int i = 0; i < 10; i++)
        {
            pair = couples.get(i) + boughtFor.get(i);
            pairArray.get(i) = pair;

            for (int j = 0; j < 10; j++)
            {
                if(pair == pairings.get(i))
                    return true;
            }
        }


        return false;

    }





}