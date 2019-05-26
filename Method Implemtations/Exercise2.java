// Importing random package which contain certain methods
import java.util.Random;

// public class Exercise2
public class Exercise2 {
	
	// Main method - contains all the calls to the created methods
	public static void main(String args[]) {
		
		// Initialises an integer array to store n values 
		int [] arr = createArray(10); 
		// Print statement informing the user that the array has not been sorted
		System.out.println("The array is not sorted ");
		// Calls the printArray function with the argument arr
		printArray(arr);
		// Assigns the variable arr with a call to the function sortArray, passing the argument arr
		arr = sortArray(arr);
		// Print statement informing the user that the array has been sorted
		System.out.println("The array is sorted");
		// Calls the printArray function, passing the argument arr
		printArray(arr);
		// Print statement printing the value which is returned after binarySearch has been called, with arguments arr and 50 respectively
		System.out.println(binarySearch(arr, 50));
	}
	
	
	// Method which prints the array, which has been passed to it as an argument
	// I initially was printing using square brackets, but decided to change it for the exact output
	public static void printArray(int [] a) {
		
		// Print statement which starts the array with a curly bracket
		System.out.print("{");
		// For loop which iterates the array a and prints the elements inside it
		for (int i = 0; i < a.length; i++)
		{
			// Conditional if statement to check if the index in a is the last element of the array
			if(i == a.length-1)
				// Print statement which prints the last element in the array and a closing curly bracket
				System.out.println(a[i] + "}");
			// Conditional else statement for the elements at index i and a comma
			else
				// Print statement which prints the element at index i and a comma 
				System.out.print(a[i] + ", ");
		}
	}
	
	
	// Method which takes an integer n as argument and returns an array of size n, containing random numbers from 1-100
	public static int [] createArray(int n) {
		
		// Initialises an integer array with maximum number of integers as n
		int [] rand_array = new int [n];

		// For loop to iterate created integer array and fill it with random numbers between 1 and 100
		for (int i = 0; i < rand_array.length; i++)
			// Sets index of integer array to random value between 1 and 100
			rand_array[i] = (int) (Math.random() * 100);
		
		// Return statement which returns the array containing the n randomly generated numbers
		return rand_array; 
	}
	
	
	// Method which takes an integer array as an argument, and sorts in ascending order
	public static int [] sortArray(int a[]) {
		
		// Nested for loops which iterate the array and move the largest numbers to the end of the list
		for(int i = 0; i < a.length; i++)
		{
			for(int j = i+1; j < a.length; j++)
			{
				// Conditional if statement to check if the value at index i is greater than the value at index j
				if(a[i]>a[j])
				{
					// Following statements swap the values and store them in each others' variable, uses a temporary variable
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;		
				}
			}
		}
		// Returns the sorted integer array
		return a;
	}
	
	
	// Method which takes two arguments: integer array and integer. It then does a binary search to find whether n is in the array or not
	public static boolean binarySearch(int a[], int n) {
		
		// Initialise a counter to store the number of time the binary search is executed
		int counter = 0;
		// Initialise the minimum index value to 0
		int min = 0;
		// Initialise the maximum index value to the length of list minus 1 (we start counting from 0)
		int max = a.length - 1;
		// Initialise an integer number_n, which holds the average of min and max
		int number_n = (min + max)/2;
		
		// While loop which continually does the binary search until the value n is found, if not found, it was not in the array to begin with
		while (min <= max)
		{
			// Counter is incremented for each run of the loop
			counter++;
			// Conditional if statement to check if the value n is greater than the value at the index a[number_n]
			if(a[number_n] < n)
			{
				// Assigns the minimum variable to one greater than the binary search result 
				min = number_n + 1;
			}
			// Conditional else if to check if the value n is equal to the value at the index a[number_n]
			else if(a[number_n] == n)
			{
				// Print statement which prints to the console the number of times it took the binary search to find the value n
				System.out.println("It took " + counter + " times to find that the value " + n + " is contained in the array");
				// Return statement returning true because the value has been found in the array
				return true;
			}
			// Conditional else to check if the value n is less than the value at the index a[number_n]
			else
			{
				// Assigns the maximum variable to one less than the binary search result 
				max = number_n - 1;
			}
			// Integer variable number_n is assigned to the average of min and max, this ensures the binary search is carried out again
			number_n = (min+max)/2;
		}
		
		// Print statement which tells the user in the console that the integer n was not present in the array 
		System.out.println("The value " + n + " is not contained in the array");
		// Return statement which returns false as the integer n has not been found in the array
		return false;
	}
	


}
