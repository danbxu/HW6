import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		String[] test = a.createBoard();
		assertTrue(test != null);
	}
}
