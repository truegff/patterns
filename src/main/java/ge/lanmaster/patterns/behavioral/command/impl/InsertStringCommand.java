package ge.lanmaster.patterns.behavioral.command.impl;

import ge.lanmaster.patterns.behavioral.command.Document;

public class InsertStringCommand extends AbstractCommand {

	private final Document document;
	private final int position;
	private final String strng;

	public InsertStringCommand(Document document, int position, String string) {
		this.document = document;
		this.position = position;
		this.strng = string;
		manager.invokeCommand(this);
	}

	/**
	 * Perform the command encapsulated by this object.
	 *
	 * @return true if this call to doCommand was successful and can be undone.
	 */
	@Override
	public boolean doIt() {
		try {
			document.insertStringCommand(position, strng);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean undoIt() {
		try {
			document.deleteCommand(position, strng.length());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
