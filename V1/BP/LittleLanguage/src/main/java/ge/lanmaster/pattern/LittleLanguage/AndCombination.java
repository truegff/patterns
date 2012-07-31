package ge.lanmaster.pattern.LittleLanguage;

/**
 * @author alexander
 */
public class AndCombination extends Combination {

    private Combination leftChild, rightChild;

    public AndCombination(Combination leftChild, Combination rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    } // contstructor(Combination, Combination)
    
    int[] contains(String s){
        int[] leftResult = leftChild.contains(s);
        int[] rightResult = rightChild.contains(s);
        if (leftResult == null || rightResult == null)
            return null;
        if (leftResult.length == 0)
            return rightResult;
        if (rightResult.length == 0)
            return leftResult;
        
        // Sort result so that they can be compared and merged
        Sorter.sort(leftResult);
        Sorter.sort(rightResult);
        
        // Count common offsets to find out if there are common
        // offsets and how many there will be.
        int commonCount = 0;
        for (int l=0, r=0; l<leftResult.length && r<rightResult.length;){
            if (leftResult[l] < rightResult[r]) {
                l++;
            } else if (leftResult[l] > rightResult[r]) {
                r++;
            } else {
                commonCount++;
                l++;
                r++;
            } // if
        } // for
        if (commonCount == 0)
            return null; // There are no common results
        
        // merge common results
        int[] myResult = new int[commonCount];
        commonCount = 0;
        for (int l=0, r=0; l<leftResult.length && r<rightResult.length;){
            if (leftResult[l] < rightResult[r]) {
                l++;
            } else if (leftResult[l] > rightResult[r]) {
                r++;
            } else {
                myResult[commonCount] = leftResult[l];
                commonCount++;
                l++;
                r++;
            } // if
        } // for
        return myResult;
    } // contains(String)
} // class AndCombination
