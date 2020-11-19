//Collaborators: Corey Parker, Daniel Xu


import java.util.*;
import java.lang.*;

public class EvilHangMan {

	//
	//call it run the game 

	/*
	 * This is the entire runTheEvilGame game. This starts with creating a set of needed ArrayLists, counter, and manyWrong.
	 * Counter will be used to check how many letters are guessed correctly and once counter is equal to set.size();, the program will
	 * exit the bigger whileloop and the user wins the game. manyWrong is set to 10, which is the total of wrong guesses
	 * the user has. After the user guesses 10 times incorrectly, the game exits. The game starts by prompting the user
	 * to input letter guesses. The methods we created will begin looking for new set of words after considering each of 
	 * the user input of different letters and narrowing down the set of of words after successive letters.
	 * 
	 * Note that the methods used in runTheEvilGame is tested in Junit testing and so we do not
	 * test runTheEvilGame method as a whole.
	 */

	public void runTheEvilGame() {
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
		System.out.println("You have 10 incorrect guesses before the game ends!");

		int manyWrong = 10;
	
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
					System.out.println("Game over! The correct word was " + evilWord + ". Or was it? Mwahahaha!");
				}
			}

		}
		if (counter == set.size()) {
			System.out.println("You won evil hangman! Give yourself a pat on the back and give us an A.");

		}

	}
}
