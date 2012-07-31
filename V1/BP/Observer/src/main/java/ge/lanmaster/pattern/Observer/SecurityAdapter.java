package ge.lanmaster.pattern.Observer;

/**
 * @author alexander
 */
public class SecurityAdapter implements SecurityObserver {

    private SecurityMonitor sm;
    
    SecurityAdapter(SecurityMonitor sm) {
        this.sm = sm;
    } // Constructor(SecurityMonitor)

    public void notify(int device, int event) {
        switch (event) {
            case ALARM:
                sm.securityAlert(device);
                break;
            case LOW_POWER:
                sm.lowpowerAlert(device);
                break;
            case DIAGNOSTIC:
                sm.diagnosticAlert(device);
                break;
        } // switch
    } // notify(int, int)
} // class SecurityAdapter
