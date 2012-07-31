package ge.lanmaster.pattern.Flyweight;

/**
 * @author alexander
 */
class MutableDocChar extends DocChar {

    private char character;

    MutableDocChar() {
        // It doesn't matter what we pass to super.
        super('\u0000');
    } // Constructor(char);

    /**
     * Return the character that this object represents.
     */
    public char getChar() {
        return character;
    }
    
    /**
     * Set the character that this object represents.
     */
    void setChar(char c) {
        this.character = c;
    }
}
