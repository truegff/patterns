package ge.lanmaster.patterns.structural.Decorator;

public class DoorControllerWrapperA extends AbstractDoorControllerWrapper {

    private final String camera; // name of camera viewing this door
    private final SurveillanceMonitor monitor; // camera's monitor

    /**
     * Constructor
     * @param wrappee The DoorController object that this
     *      object will delegate to.
     * @param camera The name of a camera that views this door.
     * @param monitor The monitor to ask to view camera's image.
     */
    public DoorControllerWrapperA(
            DoorController wrappee,
            String camera,
            SurveillanceMonitor monitor) {

        super(wrappee);
        System.out.println("DoorControllerWrapperA.constructor();");
        this.camera = camera;
        this.monitor = monitor;
    }

    /**
     * Ask the door to open if the given key is acceptable.
     */
    @Override
    public void requestOpen(String key) {
        System.out.println("DoorControllerWrapperA.requestOpen();");
        monitor.viewNow(camera);
        super.requestOpen(key);
    }
}
