import java.util.*;
import java.lang.*;

public class PlayGame {

	ArrayList<String> wordsToChooseFrom;
	Random b; 
	static String chosenWord;
	ArrayList<String> guesses;

	public String createWord() {
		InputDictionary a = new InputDictionary();
		wordsToChooseFrom = a.createGameWords();
		b = new Random();
		int random = b.nextInt(wordsToChooseFrom.size());
		chosenWord =  wordsToChooseFrom.get(random);
		return chosenWord;
	}


	public String[] createBoard() {
		String[] make = new String[chosenWord.length()];

		for (int i = 0; i < chosenWord.length(); i++) {
			make[i] = String.valueOf(chosenWord.charAt(i));

		}
		return make;
	}


	public void printBoard(String letter) {
		guesses.add(letter);
		for (int i = 0; i < chosenWord.length(); i++) {
			String b = String.valueOf(chosenWord.charAt(i));
			if (guesses.contains(b)) {
				System.out.println(b + "  ");

			}
			else {
				System.out.println("_" + "  ");
			}

		}
	}
	
	public static void main(String[] args) {
		PlayGame c = new PlayGame();
		c.createWord();
		System.out.println(c.createWord());
		c.createBoard();
		System.out.println(Arrays.toString(c.createBoard()));
		c.printBoard("a");


		

	}
}
