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
		System.out.println(a.printBoard(""));
		System.out.println();
		ArrayList<String> resetDict;
		resetDict = newDict;
		System.out.println(resetDict.size());
		String evilWord;
		
		while (counter < firstSet.size()) {
			System.out.println("Guess a letter:");
			System.out.println("_________________________");
			String input = s.next();
			while (guesses.contains(input) == true) {
				System.out.println("Please put another input.");
				input = s.next();
			}
			guesses.add(input);
			HashMap<String, ArrayList<String>> map = a.matchWords(resetDict, input);
			ArrayList<String> smallDict = a.newDictionary(map);
			evilWord = a.createEvilWord(smallDict);
			System.out.println(evilWord);
			set = a.makeEvilWordSet(evilWord);
			for (int i = 0; i < set.size(); i++) {
				for (int j = 0; j < guesses.size(); j++) {
					if(set.get(i).equals(guesses.get(j))) {
						correctGuesses.add(set.get(i));
					}
				}
			}
			ArrayList<String> truncateDict = new ArrayList<String>();
			for (int i = 0; i < smallDict.size(); i++) {
				ArrayList<String> wordSet = a.makeEvilWordSet(smallDict.get(i));
				int checker = 0;
				for (int j = 0; j < wordSet.size(); j++) {
					for (int k = 0; k < correctGuesses.size(); k++) {
						if (wordSet.get(j).equals(correctGuesses.get(k))) {
							checker++;
						}
					}
				}
				if (checker == correctGuesses.size()) {
					truncateDict.add(smallDict.get(i));
				}
				
			}
			System.out.println("_________________________");
			System.out.println("Current board:");
			System.out.println(a.printEvilBoard(evilWord,input));
			System.out.println();
			System.out.println("Incorrect guesses:");
			System.out.println(a.incorrectGuesses());
			System.out.println();
			System.out.println(truncateDict);
			resetDict = truncateDict;
			System.out.println(truncateDict.size());

			if (set.contains(input)) {
				counter++;
			}

			else {
				deathCounter++;
				if (deathCounter == 8) {
					counter = set.size() + 1;
					System.out.println("Game over! The correct word was " + evilWord + ".");
				}
			}
			System.out.println(counter);
			System.out.println(deathCounter);
		}

	}


}
