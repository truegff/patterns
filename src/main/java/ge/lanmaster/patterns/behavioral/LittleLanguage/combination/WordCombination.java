package ge.lanmaster.patterns.behavioral.LittleLanguage.combination;

import ge.lanmaster.patterns.behavioral.LittleLanguage.Combination;

public class WordCombination extends Combination {

	private String word;

	/**
	 * Constructor
	 *
	 * @param word The word that this combination requires in
	 *             a string
	 */
	public WordCombination(String word) {
		this.word = word;
	} // constructor(String)

	/**
	 * If the given string contains the word that this
	 * NotWordCombination object requires, this method returns
	 * an array of the offsets where the word occurs in the
	 * string. Otherwise this method returns null.
	 */
	@Override
	public int[] contains(String s) {
		if (s.indexOf(word) >= 0)
			return null;
		return new int[0];
	}
}