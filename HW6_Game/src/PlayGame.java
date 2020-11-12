import java.util.*;
import java.lang.*;

public class PlayGame {

	ArrayList<String> wordsToChooseFrom;
	Random b; 
	static String chosenWord;
	ArrayList<String> guesses = new ArrayList<String>();
	ArrayList<String> badGuesses = new ArrayList<String>();;
	ArrayList<String> set = new ArrayList<String>();

	public String createWord() {
		InputDictionary a = new InputDictionary();
		wordsToChooseFrom = a.createGameWords();
		b = new Random();
		int random = b.nextInt(wordsToChooseFrom.size());
		chosenWord =  wordsToChooseFrom.get(random);
		return chosenWord;
	}


	public String[] createWordArray() {
		String[] make = new String[chosenWord.length()];

		for (int i = 0; i < chosenWord.length(); i++) {
			make[i] = String.valueOf(chosenWord.charAt(i));

		}
		return make;
	}
	
	
	public ArrayList<String> makeWordSet() {
		String [] toSet = createWordArray();
		for (int i = 0; i < toSet.length; i++) { 
			if (!set.contains(toSet[i])) {
				set.add(toSet[i]);
			}
		}
		return set;
	}


	public String printBoard(String letter) {
		String output = "";
		if (!guesses.contains(letter)) {
			guesses.add(letter);
			String [] word = createWordArray();
			ArrayList<String> set = makeWordSet();
			if (!set.contains(letter)) {
				badGuesses.add(letter);
			}
			
			for (int i = 0; i < word.length; i++) {
				String b = word[i];
				if (guesses.contains(b)) {
					output+=b + "  ";

				}
				else {
					output+="_" + "  ";
				}

			}
		}
//		else {
//			System.out.println("Letter already chosen. Choose another letter please.");
//		}
		return output;
	}
	
	public String incorrectGuesses () {
		String output = "";
		for (int i = 0; i < badGuesses.size()-1; i++) {
			if (badGuesses.get(i+1) != null) {
				output+= "[" + badGuesses.get(i+1) + "]" + " ";
			}
		}

		return output;
	}

}
