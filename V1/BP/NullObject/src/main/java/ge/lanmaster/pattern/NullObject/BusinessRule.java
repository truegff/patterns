package ge.lanmaster.pattern.NullObject;

import java.util.Date;

/**
 * @author alexander
 */
public class BusinessRule {
    private WarningRouter warning;
    private Date expirationDate = new Date(Long.MAX_VALUE);

    BusinessRule() {
        if (new Date().after(expirationDate)) {
            String msg = getClass().getName()+" has expired.";
            warning.routeWarning(msg);
        } // if
    } // constructor()
} // class BusinessRules
