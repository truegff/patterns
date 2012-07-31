package ge.lanmaster.pattern.Decorator;

/**
 * @author alexander
 */
abstract class AbstractDoorControllerWrapper implements DoorControllerIF {
    private DoorControllerIF wrappee;


    /**
     * Constructor
     * @prram wrappee The object this object will delegate to.
     */
    public AbstractDoorControllerWrapper(DoorControllerIF wrappee) {
        System.out.println("AbstractDoorControllerWraper.constructor();");
        this.wrappee = wrappee;
    } // constructor(wrappee)

    /**
     * Ask the door to open if the given key is acceptable.
     */
    @Override
    public void requestOpen(String key) {
        System.out.println("AbstractDoorControllerWraper.requestOpen();");
        wrappee.requestOpen(key);
    } // requestOpen(String)

    /**
     * close the door
     */
    @Override
    public void close() {
        System.out.println("AbstractDoorControllerWraper.close();");
        wrappee.close();
    } // close()

} // class AbstractDoorControllerWrapper
