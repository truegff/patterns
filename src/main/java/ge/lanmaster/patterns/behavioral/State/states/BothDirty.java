package ge.lanmaster.patterns.behavioral.State.states;

/**
 * class to represent state for when the fields of the
 * dialog do not match the file or the working parameter
 * values.
 */
public class BothDirty extends DirtyState {

	public DirtyState nextState(int event) {
		switch (event) {
			case DIRTY_EVENT:
				return this;
			case APPLY_EVENT:
				if (parameters.applyParam()) {
					fileDirty.enter();
					return fileDirty;
				} // if
			case SAVE_EVENT:
				if (parameters.saveParam()) {
					paramDirty.enter();
					return paramDirty;
				} // if
			case REVERT_EVENT:
				if (parameters.revertParam()) {
					paramDirty.enter();
					return paramDirty;
				}
			default:
				String msg = "unexpected event " + event;
				throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * This method is called when this object becomes
	 * the current state.
	 */
	protected void enter() {
		apply.setEnabled(true);
		revert.setEnabled(true);
		save.setEnabled(true);
	}
}