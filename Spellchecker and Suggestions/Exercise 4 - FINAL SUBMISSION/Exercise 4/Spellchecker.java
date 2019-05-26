//////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*			************ SHAKIL ALI - README ******************
 
			****** VERY IMPORTANT - READ ME *******
			WELCOME TO MY SPELLCHECKER AND SPELLCHECKER SUGGESTION PROGRAM!
			I HAVE ATTACHED A READ ME FILE TO MY SUBMISSION (OUTSIDE OF MY SRC) HOWEVER I WILL REITERATE THAT INFORMATION HERE.
			PLEASE BEFORE RUNNING ANY CODE PUT THE FILE YOU WANT TO SPELLCHECK IN THE SRC FOLDER.
			THEN ALSO PUT YOUR DICTIONARY (LAHCENS DICTIONARY) IN THE SRC AND MAKE SURE IT IS NAMED 'dictionary' as a txt extension (text file)
			IF YOU HAVE DOWNLOADED MY SUBMISSION YOU WILL ALREADY HAVE THE DICTIONARY AND TEST FILE IN THE SRC 
			YOU CAN THEN RUN BOTH SPELLCHECK AND SPELLCHECKERSUGGESTION AND THE NEW FILES CREATED WILL APPEAR IN THE SRC.
			
			QUICK RUN DOWN OF MY SPELL CHECK:
			- ASKS FOR FILE NAME: ENTER YOUR FILE NAME AND ITS EXTENSION, ENSURING YOUR FILE IS IN SRC (e.g. check.txt)
			- ASKS FOR NEW FILE NAME: ENTER WHAT YOU WANT SPELLCHECKED FILE NAME TO BE (e.g. spellchecked)
			- ASKS FOR EXTENSION OF NEW FILE (e.g. doc, txt, java, html)
			- SPELLCHECKS FILE AND GIVES 2 OPTIONS FOR EACH INCORRECT WORD, EITHER:
				1) ADD WORD TO DICITIONARY BY CLICKING ENTER
				2) ENTER REPLACEMENT WORD
			- ONCE WHOLE FILE CHECKED IT WILL FINISH SPELLCHECK PROGRAM, AND HAVE NEW SPELLCHECKED FILE READY IN SRC
			
*/

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Import java modules which will be used in program
import java.util.*;
import java.io.*;

// Class Spellchecker
public class Spellchecker 
{
	// Method called spellcheck which takes on argument (the dictionary)
	public static void spellcheck(ArrayList<String> dict) throws IOException
	{
		// Prints the users directory to the screen
		System.out.println("YOUR DIRECTORY: " + System.getProperty("user.dir"));
		
		// Try statement to check for file
		try 
		{
			//////////////////////////////// ASK USER FOR FILE NAME /////////////////////////////
			
			// Ask the user for name of the file to spellcheck
			System.out.println("ENTER FILE NAME YOUR WANT TO SPELLCHECK, INCLUDING ITS EXTENSION (e.g. check.txt): ");
			// Scanner to take user input
			Scanner fileNameScanner= new Scanner(System.in);
			// Takes user input and puts in a string variable
			String fileName = fileNameScanner.nextLine();
			// Create a file variable of type File and set it to the location of the file you want to check
			File file = new File("src//"+ fileName);
			// Create a scanner object to scan the input file
			Scanner fileScan = new Scanner(file);
			
			////////////////////////////////////////////////////////////////////////////////
			
			//////////////////////// ASK USER FOR FILE NAME ////////////////////////////////
			
			// Print statement to ask what the user wants to name the new file
			System.out.println("WHAT DO YOU WANT TO NAME THE SPELLCHECKED FILE? (NAME WITHOUT EXTENSION e.g. spellchecked):");
			// Scanner to take user input
			Scanner newFileNameScanner = new Scanner(System.in);
			// Takes user input and stores 
			String newFileName = newFileNameScanner.nextLine();
			
			////////////////////////////////////////////////////////////////////////////////
			
			//////////////////////// ASK USER FOR EXTENSION ////////////////////////////////
					
			System.out.println("WHAT EXTENSION DO YOU WANT TO SAVE THE NEW FILE AS? (e.g. txt, java, doc):");
			// Scanner to take user input
			Scanner newExtensionScanner = new Scanner(System.in);
			// Takes user input
			String newExtensionName = newExtensionScanner.nextLine();
			
			////////////////////////////////////////////////////////////////////////////////
			
			// Create a PrintWriter object to write to the new file
			PrintWriter writer = new PrintWriter("src//"+newFileName+"."+ newExtensionName, "UTF-8");
			
			
			// While loop to check is the file being scanned has a next line
			while(fileScan.hasNextLine())
			{
				// Create a string, which uses the scanner to store the next line in the file 
				String sentence = fileScan.nextLine();
				// String array to store the sentence, once it has been split up and punctuation taken away
				String [] splitSentence = sentence.replaceAll("[^A-Za-z0-9 \\']+","").split("\\s+");

				
				// For loop to go through the string array
				for(int i = 0; i < splitSentence.length; i++)
				{
					// Boolean function to see if the specific string in the sentence is within the dictionary
					boolean check = dict.contains(splitSentence[i].toLowerCase());
					// If statement to see if check is false
					if(check == false)
					{
						// Print the incorrect word 
						System.out.println("'"+splitSentence[i]+"'"+" SPELT INCORRECTLY");
						// Set a string variable to splitSentence index
						String incorrectSpelling = splitSentence[i];
						// Create a new scanner to get user input, for the new word
						Scanner sc = new Scanner(System.in);
						// Print statetment giving user instructions
						System.out.println("TYPE THE WORD YOU WANT TO REPLACE THIS WORD WITH OR PRESS ENTER IF YOU WANT TO ADD "+"'"+splitSentence[i]+"'"+" TO THE DICTIONARY");
						// Create a string variable to get the next line
						String new_word = sc.nextLine();
						// If conditional to check if user enters a space
						if(new_word.length() == 0)
						{
							// Add the word entered by the user to the dictionary
							dictionary.add(splitSentence[i].toLowerCase());
							// Sort the dictionary, so the new word goes in the right place
							Collections.sort(dictionary);
							// Print statement which says that the word entered by the user, is added to the dictionary
							System.out.println("'"+splitSentence[i]+"'"+" HAS BEEN ADDED TO THE DICTIONARY");
						}
						else
						{
						// Replace the incorrect string in the line, to the correct word
							sentence = sentence.replaceFirst(splitSentence[i], new_word);
						}
					}	
				}
				// Use the writer to write the sentence to the new file
				writer.println(sentence);	
			}
			// Print statement saying spellcheck complete and which file has been modified and named
			System.out.println("SPELLCHECK HAS BEEN COMPLETED ON FILE: " +"'"+fileName +"'"+" AND HAS BEEN SAVED AS: " +"'"+ newFileName+"."+newExtensionName+"'");
			// Close the print writer
			writer.close();
			// Close the scanner
			fileScan.close();
		}
		// Catch statement
		catch (IOException e)
		{
			// Print error message
			System.out.println("ERROR: FILE NOT FOUND. PLEASE TRY AGAIN");
			// Call the spellcheck method again
			spellcheck(dictionary);
		}
	}
		
	
	// Turns contents of a text file into an ArrayList
	public static ArrayList<String> fillArray(String fileName, ArrayList<String> array) throws FileNotFoundException
	{
		// Try statement
		try
		{
			// Create a file, of type File, to the location of the file
			File file = new File("src\\"+fileName);
			// Create a new array list
		    ArrayList<String> words = new ArrayList<String>();
		    // Scanner created, which has file passed to it
		    Scanner in = new Scanner(file);
		    // While statement which checks if the file has a next line
		    while (in.hasNextLine())
		    {
		    	// Create a string variable to store the next line
		    	String nextLine = in.nextLine();
		    	// Add the next line to the array
		        array.add(nextLine);
		    }
		    
		    // For statement to iterate through the words and add them to the array
		    for(int i = 0; i < words.size(); ++i)
		    {
		    	// Print the values of array
		        System.out.println(array.get(i));
		    }

		    // Return statement
		    return array;
		}
		// Catch statement, which has an exception e
		catch(Exception e)
		{
			// Return null statement
			return null;
		}
	}
	
	
	// Initialise ArrayList for dictionary
	public static ArrayList<String> dictionary = new ArrayList<String>();
	
	// Main method 
	public static void main(String[] args) throws IOException 
	{	
			// Turn dictionary into ArrayList
			dictionary = fillArray("dictionary.txt", dictionary);
			// Call spell check, and pass the dictionary which is going to be used
			spellcheck(dictionary);	
	}
	
	
	/*
	// My code does not use Soundex, but it did previously. I have now implemented LevenshteinDistance algorithm
	// Soundex Algorithm (Parts have been adapted from online soundex algorithm - https://introcs.cs.princeton.edu/java/31datatype/Soundex.java.html) 
	public static String shakilSoundex(String s) 
	{ 
		// Create a character array to store the value of the string in upper case, and add it to the character array 
        char [] char_array = s.toUpperCase().toCharArray();
        // Create a character variable to store the first element in the character array
        char first_letter = char_array[0];

        // convert letters to numeric code
        for (int i = 0; i < char_array.length; i++) 
        {
        	// Switch statement with an index of char array
            switch (char_array[i]) 
            {
            	// If any of these letters
                case 'B':
                case 'F':
                case 'P':
                case 'V':
                	// The value at index i, in char array, will be set to 1
                	char_array[i] = '1';
                	// Break the loop statement
                    break;

                // If any of these letters
                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                	// The value at index i, in char array, will be set to 2
                	char_array[i] = '2';
                	// Break the loop statement
                    break;

                // If any of these letters
                case 'D':
                case 'T':
                	// The value at index i, in char array, will be set to 3
                	char_array[i] = '3';
                	// Break the loop statement
                    break;

                // If any of these letters
                case 'L':
                	// The value at index i, in char array, will be set to 4
                	char_array[i] = '4';
                	// Break the loop statement
                    break;

                // If any of these letters    	
                case 'M':
                case 'N':
                	// The value at index i, in char array, will be set to 5
                	char_array[i] = '5';
                	// Break the loop statement
                    break;

                // If any of these letters    	    
                case 'R':
                	// The value at index i, in char array, will be set to 6
                	char_array[i] = '6';
                	// Break the loop statement
                    break;

                // Default case
                default:
                	// The value at index i, in char array, will be set to 0
                	char_array[i] = '0';
                	// Break the loop statement
                    break;
            }
        }

        // This will remove duplicates
        String output = "" + first_letter;
        for (int i = 1; i < char_array.length; i++)
            if (char_array[i] != char_array[i-1] && char_array[i] != '0')
                output += char_array[i];

        // This truncates (adds 0's) if there are missing 
        output = output + "0000";
        return output.substring(0, 4);
    }
	*/
	
	
	// This implementation of Levenshtein Algorithm has been adapted from http://www.java2s.com/Code/Java/Data-Type/FindtheLevenshteindistancebetweentwoStrings.htm
	// My spellchecker and spellchecker suggestions utilise Levenshtein Distance Algorithm
	public static int shakilLevenshteinDistance(String s, String t) 
	{
		// Conditional if to check if either of the input strings are empty
		if (s == null || t == null) 
		{
			// This is in case any or both strings are null
			throw new IllegalArgumentException("Strings must not be null");
		}
		
		// Length of string s
		int n = s.length(); 
		// Length of string t
	    int m = t.length();

	    // Conditional if to check if the length of string s is 0
	    if (n == 0) 
	    {
	    	// return the length of string t
	    	return m;
	    } 
	    // Conditional else if statement to check if length of string 
	    else if (m == 0) 
	    {
	    	// Return the length of string s
	    	return n;
	    }

	    // Conditional if statement to check if the length of string s is greater than the length of string t
	    if (n > m) 
	    {
	          // Swap the input strings
	          String tmp = s;
	          // Set s to t
	          s = t;
	          // Set t to tmp
	          t = tmp;
	          // Set n to m
	          n = m;
	          // Set m to the length of string t
	          m = t.length();
	     }

    	 //'previous' cost array, horizontally
	     int p[] = new int[n+1]; 
	     // cost array, horizontally
	     int d[] = new int[n+1]; 
	     //placeholder to assist in swapping p and d
	     int _d[]; 

	     // indexes into strings s and t
    	 // iterates through string s
	     int i; 
	     // iterates through string t
	     int j; 

	     // jth character of string t
	     char t_j; 

	     // cost
	     int cost; 

	     // For loop to loop n times
	     for (i = 0; i<=n; i++) 
	     {
	    	 // Set the index at i of the string array p, to the value i
	    	 p[i] = i;
	     }

	     // For loop to loop m times
	     for (j = 1; j<=m; j++) 
	     {
	    	 // Set t_j to the character at the index j-1
	    	 t_j = t.charAt(j-1);
	    	 // Set the first index of string array d to j
	    	 d[0] = j;

	    	 // For loop iterating n times
	         for (i=1; i<=n; i++) 
	         {
	        	 // Set cost to the character at the i-1 index of string s
	        	 cost = s.charAt(i-1)==t_j ? 0 : 1;
	             // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
	             d[i] = Math.min(Math.min(d[i-1]+1, p[i]+1),  p[i-1]+cost);
	         }

	         // Copy current distance counts to 'previous row' distance counts
	         // Set _d to the value p
	         _d = p;
	         // Set p to the value d
	         p = d;
	         // Set d to the value _d
	         d = _d;
	      }

	      // our last action in the above loop was to switch d and p, so p now actually has the most recent cost counts
	      return p[n];
	  }
	
}
