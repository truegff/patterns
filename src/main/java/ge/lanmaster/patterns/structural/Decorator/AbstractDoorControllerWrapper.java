package ge.lanmaster.patterns.structural.Decorator;

abstract class AbstractDoorControllerWrapper implements DoorController {

	private DoorController wrappee;

	/**
	 * Constructor
	 *
	 * @prram wrappee The object this object will delegate to.
	 */
	public AbstractDoorControllerWrapper(DoorController wrappee) {
		System.out.println("AbstractDoorControllerWraper.constructor();");
		this.wrappee = wrappee;
	}

	/**
	 * Ask the door to open if the given key is acceptable.
	 */
	@Override
	public void requestOpen(String key) {
		System.out.println("AbstractDoorControllerWraper.requestOpen();");
		wrappee.requestOpen(key);
	}

	/**
	 * close the door
	 */
	@Override
	public void close() {
		System.out.println("AbstractDoorControllerWraper.close();");
		wrappee.close();
	}

}
