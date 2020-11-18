import java.util.*;
import java.lang.*;

public class EvilHangMan {

	public void EvilHangMan() {
		Scanner s = new Scanner(System.in);
		PlayGame a = new PlayGame();
		String chosenWord = a.createWord();
		ArrayList <String> set;
		ArrayList <String> firstSet = a.makeEvilWordSet(chosenWord);
		set = firstSet;
		ArrayList <String> guesses = new ArrayList <String> (); 
		ArrayList <String> correctGuesses = new ArrayList <String> (); 
		int counter = 0; 
		int deathCounter = 0;
		ArrayList<String> newDict = a.dictionarySpliter(chosenWord.length());


		System.out.println("Here is your word:");
		System.out.println(a.printEvilBoard(chosenWord,""));
		System.out.println();
		ArrayList<String> resetDict = new ArrayList<String>();
		resetDict = newDict;

		String evilWord;
		System.out.println("Input the number of incorrect guesses you would like:");
		int manyWrong = s.nextInt();
		

		while(counter < set.size()) {
			System.out.println("Guess a letter:");
			System.out.println("_________________________");
			String input = s.next();
			System.out.println(input);
			while (guesses.contains(input) == true) {
				System.out.println("Please put another input.");
				input = s.next();
			}
			guesses.add(input);
			HashMap<String, ArrayList<String>> map = a.matchWords(resetDict, input);
			ArrayList<String> smallDict = a.newDictionary(map);
			resetDict = smallDict;
			evilWord = a.createEvilWord(resetDict);
			set = a.makeEvilWordSet(evilWord);
			
			System.out.println("_________________________");
			System.out.println("Current board:");
			System.out.println(a.printEvilBoard(evilWord,input));
			System.out.println();
			System.out.println("Incorrect guesses:");
			System.out.println(a.incorrectGuesses());
			System.out.println();
			
			
			if (set.contains(input)) {
				counter++;
			}

			else {
				deathCounter++;
				if (deathCounter == manyWrong) {
					counter = set.size() + 1;
					System.out.println("Game over! The correct word was " + evilWord + ". As expected you lost. Mwahahaha!");
				}
			}

		}
		if (counter == set.size()) {
			System.out.println("You won evil hangman! Give yourself a pat on the back and give us an A.");
			
		}
		
	}
}
