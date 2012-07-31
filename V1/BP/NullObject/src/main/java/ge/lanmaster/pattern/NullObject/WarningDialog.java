package ge.lanmaster.pattern.NullObject;

/**
 * @author alexander
 */
public class WarningDialog implements WarningRouter {
    public boolean routeWarning(String warning) {
        int r = 0;
//        r = JOptionPane.showConfirmDialog(null,
//                warning,
//                "Warning",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.WARNING_MESSAGE);
        System.out.println("WarningDialog "+warning);
        return r == 0;
    } // routeWarning(String)
} // class WarningDialog
