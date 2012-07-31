package ge.lanmaster.pattern.NullObject;

/**
 * @author alexander
 */
public class IgnoreWarning implements WarningRouter{

    public boolean routeWarning(String msg) {
        System.out.println("IgnoreWarning "+msg);
        return true;
    } // routeWarning(String)
} // class IgnoreWarning
