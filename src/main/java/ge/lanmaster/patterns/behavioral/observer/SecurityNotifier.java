package ge.lanmaster.patterns.behavioral.observer;

import ge.lanmaster.patterns.behavioral.observer.observer.SecurityObserver;

import java.util.ArrayList;
import java.util.List;

public class SecurityNotifier {

	private List<SecurityObserver> observers = new ArrayList<>();

	public void AddObserver(SecurityObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(SecurityObserver observer) {
		observers.remove(observer);
	}

	// is private in common, but is set public here
	// for demonstration purposes
	public void notify(int device, int event) {
		for (SecurityObserver next : observers) {
			next.notify(device, event);
		}
	}

}
