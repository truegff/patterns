package ge.lanmaster.patterns.behavioral.observer;

public class SecurityMonitor {

	public void securityAlert(int device) {
		System.out.println("SecurityAlert: " + device);
	}

	public void diagnosticAlert(int device) {
		System.out.println("DiagnosticAlert: " + device);
	}

	public void lowPowerAlert(int device) {
		System.out.println("LowPowerAlert: " + device);
	}

}
