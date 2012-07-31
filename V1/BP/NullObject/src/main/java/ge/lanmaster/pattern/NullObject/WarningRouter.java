package ge.lanmaster.pattern.NullObject;

/**
 * @author alexander
 */
public interface WarningRouter {
    /**
     * This method sends a warning message to whatever
     * destination it considers appropriate.
     * @return true if caller should proceed with its current
     *  operation.
     */
    public boolean routeWarning(String msg);
} // interface WarningRouter
