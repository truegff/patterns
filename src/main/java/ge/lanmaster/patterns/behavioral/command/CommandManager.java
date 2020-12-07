package ge.lanmaster.patterns.behavioral.command;

import ge.lanmaster.patterns.behavioral.command.impl.AbstractCommand;

import java.util.LinkedList;

public class CommandManager {

	// The maximum number of commands to keep in the history
	private final int maxHistoryLength = 100;

	private final LinkedList<AbstractCommand> history = new LinkedList<>();
	private final LinkedList<AbstractCommand> redoList = new LinkedList<>();

	public void invokeCommand(AbstractCommand command) {
		if (command instanceof Undo) {
			undo();
			return;
		}
		if (command instanceof Redo) {
			redo();
			return;
		}
		if (command.doIt()) {
			// doIt returned true, which means it can be undone
			addToHistory(command);
		} else {
			// cannot be undone, so clear command history
			history.clear();
		}

		// After command that isn't undo/redo, ensure redo list is empty
		if (redoList.size() > 0) {
			redoList.clear();
		}
	}

	private void undo() {
		if (history.size() > 0) {
			// if history not empty
			AbstractCommand undoCmd;
			undoCmd = (AbstractCommand) redoList.removeFirst();
			undoCmd.doIt();
			history.addFirst(undoCmd);
		}
	}

	private void redo() {
		if (redoList.size() > 0) {
			// If redo list not empty
			AbstractCommand redoCmd;
			redoCmd = (AbstractCommand) redoList.removeFirst();
			redoCmd.doIt();
			history.addFirst(redoCmd);
		}
	}

	private void addToHistory(AbstractCommand command) {
		history.addFirst(command);
		// if size of hitory has exceeded maxHistoryLength,
		// remove the oldest command from the history
		if (history.size() > maxHistoryLength) {
			history.removeLast();
		}
	}
}