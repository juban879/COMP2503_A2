
import java.util.Scanner;

/** 
 * COMP 2503 Fall 2023 Assignment 2 
 * 
 * This program reads a input stream and keeps track of the statistics for avengers
 * mentioned by name, alias, or performer's last name.
 *
 * @author alyssalandeta starlynrivas jannubana
 * @date Fall 2023
*/

public class A2 {

	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };

	private int topN = 4;
	private int totalwordcount = 0;
	private Scanner input = new Scanner(System.in);
	
	private SLL<Avenger> mentionList = new SLL<Avenger>();
	private SLL<Avenger> alphabticalList = new SLL<Avenger>();
	private SLL<Avenger> mostPopularAvenger = new SLL<Avenger>(new AvengerComparatorFreqDesc());
	private SLL<Avenger> mostPopularPerformer = new SLL<Avenger>(new AvengerPerformerComparatorFreqDesc());
	
	/**
	 * Main matheod to run the program
	 * @param args
	 */
	public static void main(String[] args) {
		A2 a1 = new A2();
		a1.run();
	}

	/**
	 * This method calls the methods required to run the program
	 */
	public void run() {
		readInput();
		createdOrderedLists();
		printResults();
	}

	/**
	 * This method uses a mover node to traverse through the mentionList, adds the appropriate avenger to the other 3 singly linked lists.
	 */
	private void createdOrderedLists() {
		Node<Avenger> mover =  mentionList.start;
		while(mover != null) {
			Node<Avenger> avg = new Node<>(mover.getData());
			alphabticalList.addInOrder(avg);
			
			
			avg = new Node<>(mover.getData());
			mostPopularAvenger.addInOrder(avg);
			
			avg = new Node<>(mover.getData());
			mostPopularPerformer.addInOrder(avg);
			mover = mover.getNext();	
		}
	}

	/**
	 * read the input stream and keep track of avengers,
	 * how many times avengers are mentioned by alias or last name.
	 */
	private void readInput() {
		/*
		 In a loop, while the scanner object has not reached end of stream,
		 	- read a word.
		 	- clean up the word
		    - if the word is not empty, add the word count. 
		    - Check if the word is either an avenger alias or last name, or performer last name then
				- Create a new avenger object with the corresponding alias and last name and performer last name.
				- if this avenger has already been mentioned, increase the corresponding frequency count for the object already in the mentionList.
				- if this avenger has not been mentioned before, add the newly created avenger to the mentionList, remember to update the corresponding frequency.
		*/
		
		while (input.hasNext()) {

			String word = cleanWord(input.next());

			if (word.length() > 0) {
				totalwordcount++;
				Avenger newAvengerObject = createAvengerObject(word);
				if (newAvengerObject == null) {
					continue;
				} else {
				
					Node<Avenger> n =  mentionList.findAvenger(newAvengerObject);
					if ( n == null) {
						newAvengerObject.addFrequency(word);
						Node<Avenger> newNode = new Node<>(newAvengerObject);
						mentionList.addAvengerToEnd(newNode);
					} else {
						n.getData().addFrequency(word);
					}
				}
			}
		}
	}
		
	/**
	 * This method creates an Avenger object from the word detected from the input stream
	 * @param word String word that is detected as part of Avenger data
	 * @return new Avenger object created
	 */
	private Avenger createAvengerObject(String word) {
			for (int i = 0; i < avengerRoster.length; i++) {
				if (avengerRoster[i][0].equals(word) || avengerRoster[i][1].equals(word)
						|| avengerRoster[i][2].equals(word)) {
					return new Avenger(avengerRoster[i][0], avengerRoster[i][1], avengerRoster[i][2]);
				}
			}
			return null;
		}

	/**
	 * This method is used to "clean" the word from the input stream by removing any extra characters, spaces,
	 * and converts word to lowercase.
	 * @param next String word to be cleaned
	 * @return ret String that is cleaned 
	 */
	private String cleanWord(String next) {
		// First, if there is an apostrophe, the substring
		// before the apostrophe is used and the rest is ignored.
		// Words are converted to all lowercase.
		// All other punctuation and numbers are skipped.
		String ret;
		int inx = next.indexOf('\'');
		if (inx != -1)
			ret = next.substring(0, inx).toLowerCase().trim().replaceAll("[^a-z]", "");
		else
			ret = next.toLowerCase().trim().replaceAll("[^a-z]", "");
		return ret;
	}
	

	/**
	 * This method print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + mentionList.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		// Todo: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		mentionList.printLinkedList();

		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		// Todo: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		mostPopularAvenger.printTopFour();
		
		System.out.println();

		System.out.println("Top " + topN + " most popular performers:");
		// Todo: Print the most popular performers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		mostPopularPerformer.printTopFour();
		
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		// Todo: Print the list of avengers in alphabetical order
		alphabticalList.printLinkedList();
		
		System.out.println();
	}
}
