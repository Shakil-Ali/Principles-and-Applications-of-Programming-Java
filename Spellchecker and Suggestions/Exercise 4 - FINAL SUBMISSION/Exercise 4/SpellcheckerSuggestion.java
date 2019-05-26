//////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*			************ SHAKIL ALI - READ ME *********
 
			****** VERY IMPORTANT - READ ME ******* 
			WELCOME TO MY SPELLCHECKER AND SPELLCHECKER SUGGESTION PROGRAM!
			I HAVE ATTACHED A READ ME FILE TO MY SUBMISSION (OUTSIDE OF MY SRC) HOWEVER I WILL REITERATE THAT INFORMATION HERE.
			PLEASE BEFORE RUNNING ANY CODE PUT THE FILE YOU WANT TO SPELLCHECK IN THE SRC FOLDER.
			THEN ALSO PUT YOUR DICTIONARY (LAHCENS DICTIONARY) IN THE SRC AND MAKE SURE IT IS NAMED 'dictionary' as a txt extension (text file)
			IF YOU HAVE DOWNLOADED MY SUBMISSION YOU WILL ALREADY HAVE THE DICTIONARY AND TEST FILE IN THE SRC 
			YOU CAN THEN RUN BOTH SPELLCHECK AND SPELLCHECKERSUGGESTION AND THE NEW FILES CREATED WILL APPEAR IN THE SRC.
			
			QUICK RUN DOWN OF MY SPELL CHECK SUGGESTION (WHICH EXTENDS SPELLCHECKER):
			- ASKS FOR FILE NAME: ENTER YOUR FILE NAME AND ITS EXTENSION, ENSURING YOUR FILE IS IN SRC (e.g. check.txt)
			- ASKS FOR NEW FILE NAME: ENTER WHAT YOU WANT SPELLCHECKED FILE NAME TO BE (e.g. spellchecked)
			- ASKS FOR EXTENSION OF NEW FILE (e.g. doc, txt, java, html)
			- SPELLCHECKS FILE AND GIVES 2 OPTIONS FOR EACH INCORRECT WORD, EITHER:
				1) ADD WORD TO DICITIONARY BY CLICKING ENTER
				2) ENTER REPLACEMENT WORD
				3) ENTER NUMBER ASSOCIATED WITH EACH SUGGESTION TO REPLACE OLD INCORRECT WORD
			- ONCE WHOLE FILE CHECKED IT WILL FINISH SPELLCHECK PROGRAM, AND HAVE NEW SPELLCHECKED FILE READY IN SRC
			- NOTE: ENTERING A SUGGESTION NUMBER OUT OF THE GIVEN WILL RESULT IN A SPELLCHECK OF WHOLE FILE AGAIN TO ENSURE CORRECTNESS
			
*/

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Imports for java modules
import java.io.*;
import java.util.*;

// class SpellcheckerSuggestion which extends Spellchecker class
public class SpellcheckerSuggestion extends Spellchecker
{
	// Method called spellcheck which takes on argument (the dictionary)
	// It is an extension of the method in class Spellchecker, and it utilises the Levenshtein algorithm
	public static void spellcheck(ArrayList<String> dict) throws IOException
	{	
		// Prints the users directory to the screen
		System.out.println("YOUR DIRECTORY: " + System.getProperty("user.dir"));
		
		// Try statement to check for file
		try
		{
				//////////////////////////////// ASK FOR FILE NAME /////////////////////////////
				
				// Ask the user for name of the file to spellcheck
				System.out.println("ENTER FILE NAME YOU WANT TO SPELLCHECK, INCLUDING ITS EXTENSION (e.g. check.txt): ");
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
				System.out.println("WHAT DO YOU WANT TO NAME THE SPELLCHECKED FILE? (NAME WITHOUT EXTENSION e.g spellchecked): ");
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
							
							////////////////////////////// suggestions code (unique to SpellcheckerSuggestion) ////////////////////////////////
							
							// An empty string array list to store any words which will be suggested to the user
							ArrayList<String> list = new ArrayList<String>();
							// Set the new array list to the function levenshtein comparer, which returns an array list of similar words
							list = levenshteinComparer(splitSentence[i]);
							// If the array list is empty, no suggestions can be made to the user
							if(list.size() == 0)
							{
								// Print statement outlining no suggestions can be made for this word
								System.out.println("THERE ARE NO SUGGESTIONS FOR THIS WORD");
								// Print statement giving user instructions
								System.out.println("TYPE THE WORD YOU WANT TO REPLACE THIS WORD OR PRESS ENTER IF YOU WANT TO ADD "+"'"+splitSentence[i]+"'"+" TO THE DICTIONARY");
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
								// Else statement if user types correct spelling
								else
								{
									// Replace the incorrect string in the line, to the correct word
									sentence = sentence.replaceFirst(splitSentence[i], new_word);
								}
							}
							// Else statement for if there are suggestable words
							else
							{
								// Print statements which specify suggested words for the incorrect word
								System.out.println("DID YOU MEAN ANY OF THE FOLLOWING? ");
								// Print statement to print the suggestions list
								System.out.println(list);
								// Print statement outlining user possible actions
								System.out.println("IF YOU MEANT ANY OF THE SUGGESTIONS THEN TYPE THE CORRECT NUMBER FROM BELOW AND PRESS ENTER. ELSE ENTER A NEW WORD, OR PRESS ENTER TO ADD WORD TO DICTIONARY");
			
								// For loop iterating the suggestions and printing the index and word
								for(int j = 0; j < list.size(); j++)
								{
									// Print statement for the index and word
									System.out.println(+ j + " = " + "'" +list.get(j) + "'");
								}
								
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
								// Else is statement to check if user enters number out of bounds
								else if((new_word.matches("^\\d+(\\.\\d+)?") && (Integer.parseInt(new_word) >= list.size()))) 
								{
									System.out.println("ERROR: NUMBER ENTERED IS INVALID. MUST SPELLCHECK FILE AGAIN");
									spellcheck(dictionary);
								}
								// Else if checking if there is number entered
								else if(new_word.matches("^\\d+(\\.\\d+)?")) 
								{
									// Replace incorrect word with word selected by user from suggestions list
									sentence = sentence.replaceFirst(splitSentence[i], list.get(Integer.parseInt(new_word)));
								}
								// Else statement for if word is entered
								else
								{
									// Replace the incorrect string in the line, to the correct word given by the user
									sentence = sentence.replaceFirst(splitSentence[i], new_word);
								}
								
							}
			
						}
		
					}	
					// Use the writer to write the sentence to the new file
					writer.println(sentence);	
				}
				// Print statement saying spellcheck complete and which file has been modified and named
				System.out.println("SPELLCHECK HAS BEEN COMPLETED ON FILE: " + "'"+fileName+"'" + " AND HAS BEEN SAVED AS: " + "'" +newFileName+"."+newExtensionName+"'");
				// Close the print writer
				writer.close();
				// Close the scanner
				fileScan.close();
		}
		// Catch statement
		catch(IOException e)
		{
			// Print error message
			System.out.println("ERROR: FILE NOT FOUND. PLEASE TRY AGAIN");
			// Call the spellcheck method again
			spellcheck(dictionary);
		}
	}
	
	
	// Method which takes a word which is incorrect and add performs levenshtein distance algorithm on it with every word in the dictionary
	// If a word has a distance of 1 with the incorrect word, it is added to the suggestions array list, ready to be presented to the user
	public static ArrayList<String> levenshteinComparer(String testWord)
	{
		// An empty array list to store suggested words
		ArrayList<String> suggestionsList = new ArrayList<String>();
		// An integer variable to store the distance between incorrect word and word in dictionary
		int stringDiff;
		// For loop to iterate whole dictionary and perform levenstein distance algorithm between incorrect user word and words in dictionary 
		for(int i = 0; i < dictionary.size(); i++)
		{
			// Set the variable to the returned distance between user's word and word at index in dictionary
			stringDiff = shakilLevenshteinDistance(testWord, dictionary.get(i));
			// Check if the words have a distance of 1 or else (in which case they are very similar) 
			if(stringDiff <= 1)
			{
				// Add the word at this index to the suggested words array list
				suggestionsList.add(dictionary.get(i));
			}
		}
		// Return the suggestions array list
		return suggestionsList;
	}
	
	
	public static void main(String[] args) throws IOException 
	{	
			// Turn dictionary into ArrayList
			dictionary = fillArray("dictionary.txt", dictionary);
			// Call spell check, and pass the dictionary which is going to be used
			spellcheck(dictionary);
	}
	
	
	
}
