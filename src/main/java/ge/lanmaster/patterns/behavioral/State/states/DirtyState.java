package ge.lanmaster.patterns.behavioral.State.states;

import ge.lanmaster.patterns.behavioral.State.Parameters;

import java.awt.*;

public class DirtyState extends State {

	// Symbolistic constants for events
	public static final int DIRTY_EVENT = 1;
	public static final int APPLY_EVENT = 2;
	public static final int SAVE_EVENT = 3;
	public static final int REVERT_EVENT = 4;

	// Symbolic constants for states
	protected static BothDirty bothDirty;
	protected static FileDirty fileDirty;
	protected static ParamDirty paramDirty;
	protected static NotDirty notDirty;
	protected Parameters parameters;
	protected Button apply, save, revert;

	public DirtyState() {
		if (bothDirty == null) {
			bothDirty = new BothDirty();
			fileDirty = new FileDirty();
			paramDirty = new ParamDirty();
			notDirty = new NotDirty();
		}
	}

	public static DirtyState start(
			Parameters p,
			Button apply,
			Button save,
			Button revert
	) {
		DirtyState d = new DirtyState(){
			@Override
			protected void enter() {

			}
		};
		d.parameters = p;
		d.save = save;
		d.revert = revert;
		d.notDirty.enter();
		return d.notDirty;
	} // start(Button, Button, Button)

	/**
	 * Respond to a given event with the next state.
	 *
	 * @param event An event code.
	 * @return the next state.
	 */
	protected DirtyState nextState(int event) {
		// This non-overriden method should never be called.
		throw new IllegalAccessError();
	}

	public final DirtyState processEvent(int event) {
		DirtyState myNextState = nextState(event);
		if (this != myNextState) {
			myNextState.enter();
		}
		return myNextState;
	}

	@Override
	protected void enter() {

	}
}
