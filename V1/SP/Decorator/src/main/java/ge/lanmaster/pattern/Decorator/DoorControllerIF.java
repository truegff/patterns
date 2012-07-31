package ge.lanmaster.pattern.Decorator;

/**
 * @author alexander
 */
public interface DoorControllerIF {
    /**
     * Ask the door to open if the given key is acceptable.
     */
    public void requestOpen(String key);

    /**
     * close the door
     */
    public void close();

} // interface DoorControllerIF
