package ge.lanmaster.pattern.Decorator;

/**
 * @author alexander
 */
public class DoorControllerWrapperA extends AbstractDoorControllerWrapper {

    private String camera; // name of camera viewing this door
    private SurveillanceMonitorIF monitor; // camera's monitor

    /**
     * Constructor
     * @param wrappee The DoorController object that this
     *      object will delegate to.
     * @param camera The name of a camera that views this door.
     * @param monitor The monitor to ask to view camera's image.
     */
    public DoorControllerWrapperA(
            DoorControllerIF wrappee,
            String camera,
            SurveillanceMonitorIF monitor) {

        super(wrappee);
        System.out.println("DoorControllerWrapperA.constructor();");
        this.camera = camera;
        this.monitor = monitor;
    } // constructor(wrappee)

    /**
     * Ask the door to open if the given key is acceptable.
     */
    @Override
    public void requestOpen(String key) {
        System.out.println("DoorControllerWrapperA.requestOpen();");
        monitor.viewNow(camera);
        super.requestOpen(key);
    } // requestOpen(String)
} // class DoorControllerWrapperAs
