package ge.lanmaster.pattern.Flyweight;

/**
 * @author alexander
 */
public class DocChar extends DocumentElement {
    private char character;

    DocChar (char c) {
        character = c;
    } // Constructor(char)

    /**
     * Return the character that this objects represents
     */
    public char getChar(){
        return character;
    } // getChar()

    /**
     * This method returns a unique value that determines
     * where it is stored internally in a hash table.
     */
    public int hashCode() {
        return getChar();
    } // hashCode()

    /**
     * Redefine equals so that two DocChar objects are
     * considered equal if they represent the same character.
     */
    public boolean equals(Object o) {
//        Call getChar rather than access character directly
//        so that this method will respect any alternate way
//        a subclass has of providing the character it
//        represents.
        return ((o instanceof DocChar)
                && ((DocChar) o).getChar() == getChar());
    } // equals(Object)
} // class DocChar
