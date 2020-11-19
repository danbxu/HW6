//Collaborators: Corey Parker, Daniel Xu

import java.util.*;
import java.lang.*;

public class PlayGame {

	ArrayList<String> wordsToChooseFrom;
	Random b; 
	static String chosenWord;
	ArrayList<String> guesses = new ArrayList<String>();
	ArrayList<String> badGuesses = new ArrayList<String>();;
	ArrayList<String> set = new ArrayList<String>();
	int maxListSize = 0;
	ArrayList<String> biggestDict = new ArrayList<String>();

	
    /*
     * This method creates the word and we use a random number generator
     * to generate a number and that will be used to pull a word from the dictionary.
     * This dictionary is initially made into an arraylist and setting the upperbound
     * of the generator to the size of the dictionary arraylist. 
     */
	public String createWord() {
		InputDictionary a = new InputDictionary();
		wordsToChooseFrom = a.createGameWords();
		b = new Random();
		int random = b.nextInt(wordsToChooseFrom.size());
		chosenWord =  wordsToChooseFrom.get(random);
		return chosenWord;
	}
	
	
	/*
	 * This method will create the evilword and we use a random number generator
	 * to generate a number and that will be used to pull random word from the dictionary
	 * and this evilword will be the starting word to guess. Instead of creating the dictionary
	 * arraylist like the previous method, this will take in argument arraylist.
	 */
	public String createEvilWord(ArrayList<String> dict) {
		b = new Random();
		int random = b.nextInt(dict.size());
		String evilWord = dict.get(random);
		return evilWord;
	}
	
	
    /*
     * This method will create an array that stores every single letter, as string, 
     * of the chosen word into each cell of the array. 
     */
	public String[] createWordArray() {
		String[] make = new String[chosenWord.length()];

		for (int i = 0; i < chosenWord.length(); i++) {
			make[i] = String.valueOf(chosenWord.charAt(i));

		}
		return make;
	}
	
	
	/*
     * This method will create an array that stores every single letter, as string, 
     * of the chosen word into each cell of the array. 
     */
	public String[] createEvilWordArray(String word) {
		String[] make = new String[word.length()];

		for (int i = 0; i < word.length(); i++) {
			make[i] = String.valueOf(word.charAt(i));

		}
		return make;
	}
	
	/*
	 * This will create an arraylist that keeps track of letters and adds any letters that
	 * are not already in the arraylist. 
	 */
	public ArrayList<String> makeWordSet() {
		String [] toSet = createWordArray();
		for (int i = 0; i < toSet.length; i++) { 
			if (!set.contains(toSet[i])) {
				set.add(toSet[i]);
			}
		}
		return set;
	}
	
	/*
	 * This will create an arraylist that keeps track of letters and adds any letters that
	 * are not already in the arraylist. 
	 */
	public ArrayList<String> makeEvilWordSet(String word) {
		String [] toSet = createEvilWordArray(word);
		ArrayList<String> set = new ArrayList<String>();
		for (int i = 0; i < toSet.length; i++) { 
			if (!set.contains(toSet[i])) {
				set.add(toSet[i]);
			}
		}
		return set;
	}

    /*
     * This method prints the state of the game. If the input letter 
     * is not contained in guesses, the letter is added and checked against
     * the set created by makeWordSet() method. If the correct letter is guessed,
     * it will be displayed in console. If the letter is incorrect, the method
     * will continue to print blank spaces with underlines, indicating the letters
     * that still need to be guessed. 
     */
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

		return output;
	}
	
	
	/*
     * This method prints the state of the game. If the input letter 
     * is not contained in guesses, the letter is added and checked against
     * the set created by makeEvilWordSet() method. If the correct letter is guessed,
     * it will be displayed in console. If the letter is incorrect, the method
     * will continue to print blank spaces with underlines, indicating the letters
     * that still need to be guessed. 
     */
	public String printEvilBoard(String word ,String letter) {
		String output = "";
		if (!guesses.contains(letter)) {
			guesses.add(letter);
			String [] wordArray = createEvilWordArray(word);
			ArrayList<String> set = makeEvilWordSet(word);
			for (int i = 0; i < guesses.size(); i++) {
				if (!set.contains(guesses.get(i)) && !badGuesses.contains(guesses.get(i))) {
					badGuesses.add(guesses.get(i));
				}
			}

			for (int j = 0; j < wordArray.length; j++) {
				String b = wordArray[j];
				if (guesses.contains(b)) {
					output+=b + "  ";

				}
				else {
					output+="_" + "  ";
				}

			}
		}

		return output;
	}
	
	/*
	 * This method is used to return a string of incorrect guesses that are put in individual
	 * closing set of square brackets. 
	 */
	
	public String incorrectGuesses () {
		String output = "";
		for (int i = 0; i < badGuesses.size()-1; i++) {
			if (badGuesses.get(i+1) != null) {
				output+= "[" + badGuesses.get(i+1) + "]" + " ";
			}
		}

		return output;
	}
	
	/*
	 * This method will create an arraylist of words from the dictionary file
	 * that have the same length as the input wordlength. For example, if wordlength = 7, 
	 * this method will pull all words that has length 7 from the dictionary file and put all
	 * these words into an arraylist. 
	 */
	
	//check more than notnull, need a test begin/began vs egger in the other dictionary
	//word that goes in the right family //using a binary to make sure the dictionary is split correctly
	//what is the correct answer 5/6 combinations of letters _ _ _ _
	public ArrayList<String> dictionarySpliter(int wordlength) {
		
		ArrayList<String> splitDictionary = new ArrayList<>(); 
		InputDictionary a = new InputDictionary();
		wordsToChooseFrom = a.createGameWords();
		
		
		for (int i = 0; i < wordsToChooseFrom.size(); i++) {
			if (wordsToChooseFrom.get(i).length() == wordlength) {
				splitDictionary.add(wordsToChooseFrom.get(i));
			}
	   
		}
		
		return splitDictionary;
	}
	
	/*
	 * This method will create [0,1] binaries by checking letter against the word. Creating
	 * this binary will make it easier to check against each letter of the word and use it
	 * as a key when we use hashmaps. The first forloop will first create and array of strings
	 * of each letter of the input word and the second word will put 1 (if the key matches) and 0
	 * (if the key does not match). The ending result is a key that can be used for hashmapping.
	 */
	public String createMapKey(String word, String letter) {
		String key = "";
		String[] array = new String[word.length()];

		for (int i = 0; i < word.length(); i++) {
			array[i] = String.valueOf(word.charAt(i));

		}
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(letter)) {
				key += "1";
			}
			else {
				key+= "0";
			}
		}
		return key;
	}
	
	
	/*
	 * This method will take in arraylist of words that have the same length as the current word to be guessed
	 * and a letter. First, the method will create a key for every word in the splitdicionary file and that 
	 * key of binaries will be checked against all the words and this will include all words that
	 * match the binaries, where 1s digit signifies letter exists at the certain location of the key and 0s
	 * digit is where the letter doesn't. This will refine the wordFamilies by looking at matches based on letter match.
	 * 
	 */
	
	public HashMap<String, ArrayList<String>> matchWords (ArrayList<String> splitDictionary, String letter) {
		HashMap<String, ArrayList<String>> wordFamilies = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < splitDictionary.size(); i++) {
			String key = createMapKey(splitDictionary.get(i), letter);
			if (wordFamilies.get(key) == null) { //just made this change
				ArrayList<String> words = new ArrayList<String>();
				words.add(splitDictionary.get(i));
				wordFamilies.put(key, words);
			}
			else {
				ArrayList<String> created = wordFamilies.get(key);
				created.add(splitDictionary.get(i));
				wordFamilies.put(key, created);
			}
		}
		return wordFamilies;
	}
	
	
	/*
	 * This method will repeated update the newDictionary arraylist by checking the matching value
	 * from the hashmap input and update the biggestDict. 
	 */
	
	public ArrayList<String> newDictionary (HashMap<String, ArrayList<String>> matchWords) {
		matchWords.forEach((k,v) -> {
			if (v.size() > maxListSize) {
				maxListSize = v.size();
				biggestDict = v;
			}
		});
		maxListSize = 0;
		return biggestDict;
	}

}
