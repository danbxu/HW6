//Collaborators: Corey Parker, Daniel Xu

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * This will input the dictionary of words that can be choosed from
 * for our evilhangman game. 
 */
public class InputDictionary {
	
	public ArrayList<String> createGameWords () {
		ArrayList<String> wordsFromDictionary = new ArrayList<>();
	    String userDictionary = "engDictionary.txt";
		File userFile = new File(userDictionary); 
		
		try {
			//create ArrayList wordsFromUserFile
			Scanner fileScanner = new Scanner(userFile);
			while (fileScanner.hasNextLine()) { 
				wordsFromDictionary.add(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file");
			e.printStackTrace(); 
		}
		return wordsFromDictionary;//ArrayList of words 
	}

}
