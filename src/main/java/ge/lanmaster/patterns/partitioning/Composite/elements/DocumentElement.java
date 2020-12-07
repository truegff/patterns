package ge.lanmaster.patterns.partitioning.Composite.elements;

import ge.lanmaster.patterns.partitioning.Composite.elements.CompositeDocumentElement;

import java.awt.*;

public interface DocumentElement {

    /**
     * Return this object's parent or null if parentless.
     */
    CompositeDocumentElement getParent();

    /**
     * Return the Font associated with this object.
     */
    Font getFont();

    /**
     * Associate a Font with this object.
     * @param font The font to associate with this object.
     */
    void setFont(Font font);

    /**
     * Return the number of characters that this object
     * contains.
     */
    int getCharLength();
}
