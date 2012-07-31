package ge.lanmaster.pattern.Flyweight;

import java.util.HashMap;

/**
 * @author alexander
 */
public class DocCharFactory {

    private MutableDocChar myChar = new MutableDocChar();
    /**
     * Collection of previously created DocChar objects.
     */
    private HashMap docCharPool = new HashMap();

    /**
     * Return a DocChar object that represents the given character.
     */
    synchronized DocChar getDocChar(char c) {
        myChar.setChar(c);
        DocChar thisChar = (DocChar) docCharPool.get(myChar);
        if (thisChar == null) {
            thisChar = new DocChar(c);
            docCharPool.put(thisChar, thisChar);
        } // if
        return thisChar;
    } // getDocChar(char)

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
}
