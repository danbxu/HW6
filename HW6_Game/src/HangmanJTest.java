import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;

class HangmanJTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	//This checks for the word and ensures it is not null
	@Test
	void createWord() {
		PlayGame a = new PlayGame();
		String test = a.createWord();
		assertNotNull(test);
	}
	
	//this is creates the array of letters and ensures it is not null
	@Test
	void createArray() {
		PlayGame a = new PlayGame();
		a.createWord();
		String[] test = a.createWordArray();
		assertNotNull(test);
	}
	/*This checks to ensure that the correct letter is accepted
	 * and it is not null
	 * 
	 */
	@Test
	void printBoard() {
		PlayGame a = new PlayGame();
		a.createWord();
		String test = a.printBoard("");
		assertNotNull(test);
		String test1= a.printBoard("a");
		assertNotNull(test1);
		String test2= a.printBoard("e");
		assertNotNull(test2);
		String test3= a.printBoard("i");
		assertNotNull(test3);
		String test4= a.printBoard("o");
		assertNotNull(test4);
		String test5= a.printBoard("u");
		assertNotNull(test5);
		String test6= a.printBoard("y");
		assertNotNull(test6);
		String test7= a.printBoard("y");
		assertNotNull(test7);
	}
	/*
	 * This checks for putting the correct guesses and incorrect guesses
	 */
	@Test
	void inCorrectGuesses() {
		PlayGame a = new PlayGame();
		a.createWord();
		a.printBoard("");
		a.printBoard("");
		a.printBoard("x");
		a.printBoard("z");
		a.printBoard("q");
		a.printBoard("w");
		a.printBoard("k");
		String test = a.incorrectGuesses();
		assertNotNull(test);
	}
	
	// This checks if the set of unique letters is created 
	@Test
	void makeWordSet() {
		PlayGame a = new PlayGame();
		a.createWord();
		assertNotNull(a.makeWordSet());
	}
	
	//This checks the regularhangman
	@Test
	void RegularHangmanRunner() {
		RegularHangmanRunner a = new RegularHangmanRunner();
		assertNotNull(a);
	}
	
	//This checks for the correct key is made in respect to the word and letter's positions
	@Test
	void createKeyTest() {
		PlayGame a = new PlayGame();
		String b = a.createMapKey("hello", "l");
		assertEquals(b, "00110", "it failed");
	}
	
	//This checks if the dictionary is split appropriately initially with all words of length 4
	@Test
	void dictionarySplitter() {
		PlayGame a = new PlayGame();
		ArrayList<String> dict = a.dictionarySpliter(4);
		assertNotNull(dict);

	}
	
	/*
	 * This checks the correct split and makes sure that the key created does not 
	 * include the letter e. Thus, the split dictionary is made appropriately. 
	 */
	@Test
	void creatHash() {
		PlayGame a = new PlayGame();
		ArrayList<String> dict = a.dictionarySpliter(4);
		HashMap<String, ArrayList<String>> b = a.matchWords(dict, "e");
		assertNotNull(b.get("0000"));
		ArrayList<String> c = a.newDictionary(b);
		assertNotNull(c);

	}
	
	
	/*
	 * This checks the letter printed and what is saved into the string
	 * is not null
	 */
	@Test
	void printEvilBoard() {
		PlayGame a = new PlayGame();
		String c = a.printEvilBoard("hello", "l");
		String d = a.printEvilBoard("hello", "l");
		String e = a.printEvilBoard("hello", "u");
		assertNotNull(c);

	}
	
	
    /*
     * This checks if evilword is created correctly 
     */
	@Test
	void createEvilWord() {
		PlayGame a = new PlayGame();
		ArrayList<String> b = a.dictionarySpliter(4);
		assertNotNull(a.createEvilWord(b));


	}
	
	
	

}
