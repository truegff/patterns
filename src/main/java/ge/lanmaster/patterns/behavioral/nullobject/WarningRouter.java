package ge.lanmaster.patterns.behavioral.nullobject;

public interface WarningRouter {

	/**
	 * This method sends a warning message to whatever
	 * destination it considers appropriate.
	 *
	 * @return true if caller should proceed with its current
	 * operation.
	 */
	boolean routeWarning(String msg);

}
