package ge.lanmaster.patterns.behavioral.observer;

import ge.lanmaster.patterns.behavioral.observer.observer.SecurityLoggingObserver;
import ge.lanmaster.patterns.behavioral.observer.observer.SecurityMonitorObserverAdapter;
import ge.lanmaster.patterns.behavioral.observer.observer.SecurityObserver;

public class Demo {

	public static void main(String[] args) {

		System.out.println("Observer Pattern");

		SecurityObserver loggingObserver = new SecurityLoggingObserver();

		SecurityMonitor monitor = new SecurityMonitor();
		SecurityObserver observerAdapter = new SecurityMonitorObserverAdapter(monitor);

		SecurityNotifier notifier = new SecurityNotifier();
		notifier.AddObserver(loggingObserver);
		notifier.AddObserver(observerAdapter);

		// works :)
		notifier.notify(1, SecurityObserver.ALARM);

		System.out.println("");

		notifier.notify(1, SecurityObserver.DIAGNOSTIC);

		System.out.println("");

		notifier.notify(1, SecurityObserver.LOW_POWER);

	}

}
