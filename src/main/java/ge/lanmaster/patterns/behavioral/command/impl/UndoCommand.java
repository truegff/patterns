package ge.lanmaster.patterns.behavioral.command.impl;

import ge.lanmaster.patterns.behavioral.command.Undo;

public class UndoCommand extends AbstractCommand implements Undo {

	/**
	 * This implementation of doIt does not actually do anything. The logic for
	 * undo is in the CommandManager class.
	 */
	@Override
	public boolean doIt() {
		// This method should never be called
		throw new NoSuchMethodError();
	} // doIt()

	/**
	 * This implementation of undoIt does not actually do anything. Undo
	 * commands are not undone. Instead, a redo command is issued.
	 */
	@Override
	public boolean undoIt() {
		// This method should never be called
		throw new NoSuchMethodError();
	}
}
