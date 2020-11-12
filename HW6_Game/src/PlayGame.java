import java.util.*;
import java.lang.*;

public class PlayGame {

	ArrayList<String> wordsToChooseFrom;
	Random b; 
	static String chosenWord;
	ArrayList<String> guesses = new ArrayList<String>();
	ArrayList<String> badGuesses = new ArrayList<String>();

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


	public String printBoard(String letter) {
		String output = "";
		if (!guesses.contains(letter)) {
			guesses.add(letter);
			String [] word = createWordArray();
			for (int i = 0; i < word.length; i++) {
				String b = word[i];
				if (guesses.contains(b)) {
					output+=b + "  ";

				}
				else {
					output+="_" + "  ";
					badGuesses.add(letter);
				}

			}
		}
		else {
			System.out.println("Letter already chosen. Choose another letter please.");
		}
		return output;
	}
	
	public String incorrectGuesses () {
		String output = "";
		for (int i = 0; i < badGuesses.size(); i++) {
			output+= "[" + badGuesses.get(i) + "]" + " ";
		}
	
		return output;
	}
	
}
