package ge.lanmaster.pattern.Command;

import com.sun.xml.internal.txw2.Document;

/**
 * @author alexander
 */
public class InsertStringCommand extends AbstractCommand {

    Document document;
    int position;
    String strng;

    /**
     * Constructor
     * @param document
     * @param position
     * @param strng
     */
    public InsertStringCommand(Document document,
            int position,
            String strng) {
        this.document = document;
        this.position = position;
        this.strng = strng;
        manager.invokeCommand(this);
    } // Constructor(Document, int, String)

    /**
     * Perform the command encapsulated by this object.
     * @return true if this call to doCommand was successful
     *  and can be undone.
     */
    public boolean doIt() {
        try {
            document.insertStringCommand(position, strng);
        } catch (Exception e) {
            return false;
        } // try
        return true;
    } // doIt()

    public boolean undoIt() {
        try {
            document.deleteCommand(position, strng.length());
        } catch (Exception e) {
            return false;
        } // try
        return true;
    } // undoIt()
} // class InsertStringCommand