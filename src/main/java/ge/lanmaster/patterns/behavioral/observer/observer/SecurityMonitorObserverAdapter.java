package ge.lanmaster.patterns.behavioral.observer.observer;

import ge.lanmaster.patterns.behavioral.observer.SecurityMonitor;

public class SecurityMonitorObserverAdapter implements SecurityObserver {

	private final SecurityMonitor monitor;

	public SecurityMonitorObserverAdapter(SecurityMonitor monitor) {
		this.monitor = monitor;
	}

	public void notify(int device, int event) {
		switch (event) {
			case ALARM: {
				monitor.securityAlert(device);
				break;
			}
			case LOW_POWER: {
				monitor.lowPowerAlert(device);
				break;
			}
			case DIAGNOSTIC: {
				monitor.diagnosticAlert(device);
				break;
			}
		}
	}
}