import java.util.*;

public class ChristmasDrawOld {
	public static void main(String args[]) {

		// Arrays for x (couple1) and y (couple2) 
		ArrayList<Integer> couple1 = new ArrayList<Integer>();
		ArrayList<Integer> couple2 = new ArrayList<Integer>();
		
		// Prints couples arrayLists
		//System.out.println(Shuffle(couple1));
		//System.out.println(Shuffle(couple2));
		
		// For loop will get elements from couples
		/*
		for (int i = 0; i < couple1.size(); i++)		
		{
			System.out.println(couple1.get(i) + "x will not buy for " + couple2.get(i) + "y");
		}
		*/
		
		if (CheckPair(Shuffle(couple1), Shuffle(couple2)) == true)
		{
			System.out.print("There a same couple");
		}
		else
		{
			for (int i = 0; i < couple1.size(); i++)		
			{
				System.out.println(couple1.get(i) + "x will not buy for " + couple2.get(i) + "y");
			}
		}



		

	}

	

	// Function to generate random array
	public static ArrayList<Integer> Shuffle(ArrayList<Integer> inputArray) {
		
		// Adds the numbers 1-5 for the arrayLists
		inputArray.add(1); 
        inputArray.add(2); 
        inputArray.add(3); 
        inputArray.add(4); 
        inputArray.add(5);
		
        // Randomly shuffle the arrayLists
        Collections.shuffle(inputArray);
        
        // Return shuffled arrayLists
  		return(inputArray);
	}



	// Function to check if pairs are from same couple
	public static boolean CheckPair(ArrayList<Integer> inputArray1, ArrayList<Integer> inputArray2) {
		
		// Variable to store size of an array
		int n = inputArray1.size();

		// For loop to iterate through inputArray 1. If statement to check if any pair is an equivalent pair.
		for (int i = 0; i < n; i++)
		{
			if (inputArray1.get(i) == inputArray2.get(i))
			{
				System.out.println(" Same couple pair detected ");
				System.out.println(inputArray1);
				System.out.println(inputArray2);
				return true;
			}
		}
		return false;

	}
	





}