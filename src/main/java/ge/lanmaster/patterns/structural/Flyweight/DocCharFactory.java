package ge.lanmaster.patterns.structural.Flyweight;

import java.util.HashMap;

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
        }
        return thisChar;
    }


}
