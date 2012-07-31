package ge.lanmaster.pattern.Observer;

/**
 * @author alexander
 */
class SecurityMonitor {

    void securityAlert(int device) {
        System.out.println("SecurityAlert: "+device);
    }

    void diagnosticAlert(int device) {
        System.out.println("DiagnosticAlert: "+device);
    }

    void lowpowerAlert(int device) {
        System.out.println("LowPowerAlert: "+device);
    }

}
