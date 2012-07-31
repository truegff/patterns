package ge.lanmaster.pattern.State;

import java.awt.Button;

/**
 * @author alexander
 */
public class DirtyState {
    // Symbolistic constants for events

    public static final int DIRTY_EVENT = 1;
    public static final int APPLY_EVENT = 2;
    public static final int SAVE_EVENT = 3;
    public static final int REVERT_EVENT = 4;
    // Symbolic constants for states
    private static BothDirty bothDirty;
    private static FileDirty fileDirty;
    private static ParamDirty paramDirty;
    private static NotDirty notDirty;
    private Parameters parameters;
    private Button apply, save, revert;

    DirtyState() {
        if (bothDirty == null) {
            bothDirty = new BothDirty();
            fileDirty = new FileDirty();
            paramDirty = new ParamDirty();
            notDirty = new NotDirty();
        } // if
    } // constructor()

    public static DirtyState start(
            Parameters p,
            Button apply,
            Button save,
            Button revert
            ) {
        DirtyState d = new DirtyState();
        d.parameters = p;
        d.save = save;
        d.revert = revert;
        d.notDirty.enter();
        return d.notDirty;
    } // start(Button, Button, Button)

    /**
     * Respond to a given event with the next state.
     * @param event
     *  An event code.
     * @return
     *  the next state.
     */
    protected DirtyState nextState(int event) {
        // This non-overriden method should never be called.
        throw new IllegalAccessError();
    } // nextState(int)

    /**
     *
     */
    public final DirtyState processEvent(int event) {
        DirtyState myNextState = nextState(event);
        if (this != myNextState) {
            myNextState.enter();
        } // if
        return myNextState;
    } // processEvent(int)

    /**
     * This method is called when this object becomes the
     * current state.
     */
    private void enter() { }

    /**
     * class to represent state for when the fields of the
     * dialog do not match the file or the working parameter
     * values.
     */
    private class BothDirty extends DirtyState {
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
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
            } // switch(event)
        } // nextState(int)

        /**
         * This method is called when this object becomes
         * the current state.
         */
        protected void enter() {
            apply.setEnabled(true);
            revert.setEnabled(true);
            save.setEnabled(true);
        } // enter
    } // class BothDirty
}
