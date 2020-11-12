import java.util.*;
import java.lang.*;

public class RegularHangMan {


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
