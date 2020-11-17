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
	
	@Test
	void createWord() {
		PlayGame a = new PlayGame();
		String test = a.createWord();
		assertNotNull(test);
	}
	
	@Test
	void createArray() {
		PlayGame a = new PlayGame();
		a.createWord();
		String[] test = a.createWordArray();
		assertNotNull(test);
	}
	
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
	
	@Test
	void makeWordSet() {
		PlayGame a = new PlayGame();
		a.createWord();
		assertNotNull(a.makeWordSet());
	}
	
	@Test
	void RegularHangmanRunner() {
		RegularHangmanRunner a = new RegularHangmanRunner();
		assertNotNull(a);
	}
	
	@Test
	void createKeyTest() {
		PlayGame a = new PlayGame();
		String b = a.createMapKey("hello", "l");
		assertEquals(b, "00110", "it failed");
	}
	
	@Test
	void dictionarySplitter() {
		PlayGame a = new PlayGame();
		ArrayList<String> dict = a.dictionarySpliter(4);
		assertNotNull(dict);

	}
	
	void creatHash() {
		PlayGame a = new PlayGame();
		ArrayList<String> dict = a.dictionarySpliter(4);
		HashMap<String, ArrayList<String>> b = a.matchWords(dict, "e");
		assertNotNull(b.get("0000"));

	}
	
	
//	@Test
//	void RegularHangman() {
//		RegularHangMan a = new RegularHangMan();
//		assertEquals(a.RegularHangman(), "You won!");
//	}
}
