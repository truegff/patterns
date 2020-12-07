package ge.lanmaster.patterns.behavioral.command.impl;

import ge.lanmaster.patterns.behavioral.command.CommandManager;

public abstract class AbstractCommand {

	public final static CommandManager manager = new CommandManager();

	/**
	 * Perform the command encapsulated by this object.
	 *
	 * @return true if successful and can be undone.
	 */
	public abstract boolean doIt();

	/**
	 * Undo the last invocation of doIt.
	 *
	 * @return true if the undo was successful
	 */
	public abstract boolean undoIt();

}
