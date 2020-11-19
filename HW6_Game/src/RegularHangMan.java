//Collaborators: Corey Parker, Daniel Xu

import java.util.*;
import java.lang.*;

public class RegularHangMan {

    /*
     * This is the regular hangman game. This game will start by choosing a single word
     * from the dictionary and that said word will be guessed by the user. The counter (incremented) 
     * will be number of letters correctly guessed and exists in set.size(); (set.size() is
     * an array of letters of the word to be guessed and when counter = set.size();
     * the game will end. Keep in mind, set.size() is made with makeWordSet(); which creates
     * a set of unique letters. If the user guesses incorrectly, the deathcounter is incremented
     * and once deathcounter = 8, the game will end. 
     */
	public void RegularHangman() {
		Scanner s = new Scanner(System.in);
		PlayGame a = new PlayGame();
		String chosenWord = a.createWord();
		ArrayList <String> set = a.makeWordSet();
		ArrayList <String> guesses = new ArrayList <String> (); 
		int counter = 0; 
		int deathCounter = 0;
		System.out.println("Here is your word:");
		System.out.println(a.printBoard(""));
		System.out.println();
		
		while (counter < set.size()) {
			System.out.println("Guess a letter:");
			System.out.println("_________________________");
			String input = s.next();
			while (guesses.contains(input) == true) {
				System.out.println("Please put another input.");
				input = s.next();
			}
			guesses.add(input);
			System.out.println("_________________________");
			System.out.println("Current board:");
			System.out.println(a.printBoard(input));
			System.out.println();
			System.out.println("Incorrect guesses:");
			System.out.println(a.incorrectGuesses());
			System.out.println();

			if (set.contains(input)) {
				counter++;
			}
			else {
				deathCounter++;
				if (deathCounter == 8) {
					counter = set.size() + 1;
					System.out.println("Game over! The correct word was " + chosenWord + ".");
				}
			}
		}
		if (counter == set.size()) {
			System.out.println("You won!");
			
		}
	}
}
