package ge.lanmaster.patterns.behavioral.observer.observer;

public interface SecurityObserver {

	int ALARM = 1;
	int LOW_POWER = 2;
	int DIAGNOSTIC = 3;

	/**
	 * This method is called to deliver a security notification.
	 *
	 * @param device ID of the device this notification came from.
	 * @param event  This should be one of the above constants.
	 */
	void notify(int device, int event);

}