package ge.lanmaster.patterns.structural.Decorator;

public interface DoorController {

    /**
     * Ask the door to open if the given key is acceptable.
     */
    void requestOpen(String key);

    /**
     * close the door
     */
    void close();

}
