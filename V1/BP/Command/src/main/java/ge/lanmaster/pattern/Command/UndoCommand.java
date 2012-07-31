package ge.lanmaster.pattern.Command;

/**
 * @author alexander
 */
public class UndoCommand extends AbstractCommand implements Undo {

    /**
     * This implementation of doIt does not actually do
     * anything. The logic for undo is in the CommandManager
     * class.
     */
    public boolean doIt() {
        // This method should never be called
        throw new NoSuchMethodError();
    } // doIt()

    /**
     * This implementation of undoIt does not actually do
     * anything. Undo commands are not undone. Instead, a
     * redo command is issued.
     */
    public boolean undoIt() {
        // This method should never be called
        throw new NoSuchMethodError();
    } // undoIt()
} // class UndoCommand
