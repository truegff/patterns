package ge.lanmaster.patterns.behavioral.LittleLanguage.combination;

import ge.lanmaster.patterns.behavioral.LittleLanguage.Combination;

public class OrCombination extends Combination {

	private Combination leftChild, rightChild;

	/**
	 * constructor
	 *
	 * @param leftChild  This object's left child.
	 * @param rightChild This object's right child.
	 */
	public OrCombination(Combination leftChild, Combination rightChild) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public int[] contains(String s) {
		int[] leftResult = leftChild.contains(s);
		int[] rightResult = rightChild.contains(s);
		if (leftResult == null)
			return rightResult;
		if (rightResult == null)
			return leftResult;
		if (leftResult.length == 0)
			return leftResult;
		if (rightResult.length == 0)
			return rightResult;

		// create array of combined results
		int[] myResult = new int[leftResult.length + rightResult.length];
		System.arraycopy(leftResult, 0, myResult, 0, leftResult.length);
		System.arraycopy(rightResult, 0, myResult, leftResult.length, rightResult.length);
		return myResult;
	}
}
