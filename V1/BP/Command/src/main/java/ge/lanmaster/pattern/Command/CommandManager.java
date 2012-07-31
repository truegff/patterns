package ge.lanmaster.pattern.Command;

/**
 * @author alexander
 */
class CommandManager {
    // The maximum number of commands to keep in the history
    private int maxHistoryLength = 100;

    private LinkedList history = new LinkedList();
    private LinkedList redoList = new LinkedList();

    public void invokeCommand(AbstractCommand command) {
        if (command instanceof Undo) {
            undo();
            return;
        } // if undo
        if (command instanceof Redo) {
            redo();
            return();
        } // if redo
        if (command.doIt()) {
            // doIt returned true, which means it can be undone
            addToHistory(command);
        } else {
            // cannot be undone, so clear command history
            history.clear();
        } // if
        // After command that isn't undo/redo, ensure redo
        // list is empty
        if (redoList.size() > 0)
            redoList.clear();
    } // invokeCommand(AbstractCommand)

    private void undo() {
        if (history.size() > 0) {
            // if history not empty
            AbstractCommand undoCmd;
            undoCmd = (AbstractCommand) redoList.removeFirst();
            undoCmd.doIt();
            history.addFirst(undoCmd);
        } // if
    } // undo()

    private void redo() {
        if (redoList.size() > 0) {
            // If redo list not empty
            AbstractCommand redoCmd;
            redoCmd = (AbstractCommand)redoList.removeFirst();
            redoCmd.doIt();
            history.addFirst(redoCmd);
        } // if
    } // redo()

    private void addToHistory(AbstractCommand command) {
        history.addFirst(command);
        // if size of hitory has exceeded maxHistoryLength,
        // remove the oldest command from the history
        if (history.size() > maxHistoryLength)
            history.removeLast();
    } // addToHistory(AbstractCommand)
} // class CommandManager
