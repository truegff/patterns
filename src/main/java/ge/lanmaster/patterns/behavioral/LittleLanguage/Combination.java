package ge.lanmaster.patterns.behavioral.LittleLanguage;

public abstract class Combination {
	/**
	 * If the given string contains the words that is
	 * Combination object requires, this method returns an
	 * array of ints. In most cases, the array contains the
	 * offsets of the words in the string that are required by
	 * this combination. However, if the array is empty, then
	 * all the words in the string satisfy the combination.
	 * If the given string does not contain the words that this
	 * Combination object requires, then this method returns
	 * null.
	 */
	public abstract int[] contains(String s);
}
