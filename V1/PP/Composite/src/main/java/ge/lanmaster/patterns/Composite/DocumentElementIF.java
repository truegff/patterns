package ge.lanmaster.patterns.Composite;

import java.awt.*;

public interface DocumentElementIF {

    /**
     * Return this object's parent or null if parentless.
     */
    public CompositeDocumentElement getParent();

    /**
     * Return the Font associated with this object.
     */
    public Font getFont();

    /**
     * Associate a Font with this object.
     * @param font The font to associate with this object.
     */
    public void setFont(Font font);

    /**
     * Return the number of characters that this object
     * contains.
     */
    public int getCharLength();
}
