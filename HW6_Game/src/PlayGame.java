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
	
	public ArrayList<String> dictionarySpliter(int wordlength) {
		//start with createword, and .length and put into dSpliter and
		//dictionary have to split to yes/no to length of chosenWord
		
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
	
	public HashMap<String, ArrayList<String>> matchWords (ArrayList<String> splitDictionary, String letter) {
		HashMap<String, ArrayList<String>> wordFamilies = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < splitDictionary.size(); i++) {
			String key = createMapKey(splitDictionary.get(i), letter);
			if (wordFamilies.get(key) == null) {
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
	
	
	public ArrayList<String> newDictionary (HashMap<String, ArrayList<String>> matchWords) {
		matchWords.forEach((k,v) -> {
			if (v.size() > maxListSize) {
				maxListSize = v.size();
				biggestDict = v;
			}
		});
		return biggestDict;
	}
		
		
		/*
		 * 
		System.out.println("Method 3");
		//3. Lambda
		db.forEach((k, v) -> {
			if (v.contains(actor))
				System.out.println(k);
			//myMovies.add(k);
		});
		 */
		
		
//		return a;
//		
//	}

}
