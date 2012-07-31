package ge.lanmaster.pattern.Flyweight;

import java.util.Vector;

/**
 * @author alexander
 */
abstract class DocumentContainer extends DocumentElement {
    // Collection of this object's children

    private Vector children = new Vector();
    /**
     * This is the font associated with this object. If the
     * font variable is null, then this object's font will
     * be inherited through the container hierarchy from an
     * enclosing object.
     */
    private Font font;
    DocumentContainer parent; //this object's container

    /**
     * Return the child of this object at the given position.
     */
    public DocumentElement getChild(int index) {
        return (DocumentElement) children.elementAt(index);
    } // getChild(int)

    /**
     * Make the given DocumentElement a child of this object.
     */
    public synchronized void addChild(DocumentElement child) {
        synchronized (child) {
            children.addElement(child);
            if (child instanceof DocumentContainer) {
                ((DocumentContainer) child).parent = this;
            }
        } // synchronized
    } // addChild(DocumentElement)

    /**
     * Make the given DocumentElement NOT a child of this
     * object.
     */
    public synchronized void removeChild(DocumentElement child) {
        synchronized (child) {
            if (child instanceof DocumentContainer
                    && this == ((DocumentContainer) child).parent)
            {
                ((DocumentContainer) child).parent = null;
            }
            children.removeElement(child);
        }
    }

    /**
     * Return this object's parent or null if it has no parent.
     */
    public DocumentContainer getParent() {
        return parent;
    } // getParent();

    /**
     * Return the Font associated with this object. If no
     * Font is associated with this object, return its
     * parent's Font. If no Font is associated with this
     * object's parent, then return null.
     */
    public Font getFont(){
        if (font  != null)
            return font;
        else if (parent!=null)
            return parent.getFont();
        else
            return null;
    }

    /**
     * Associate a Font with this object.
     */
    public void setFont(Font font){
        this.font = font;
    }
}
