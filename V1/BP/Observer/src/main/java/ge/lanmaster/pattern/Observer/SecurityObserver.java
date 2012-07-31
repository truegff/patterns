package ge.lanmaster.pattern.Observer;

/**
 * @author alexander
 */
public interface SecurityObserver {
    public final int ALARM = 1;
    public final int LOW_POWER = 2;
    public final int DIAGNOSTIC = 3;

    /**
     * This method is called to deliver a security notification.
     * @param device
     *  ID of the device this notification came from.
     * @param event
     *  This should be one of the above constants.
     */
    public void notify(int device, int event);
} // interface SecurityObserver
