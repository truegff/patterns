package ge.lanmaster.patterns.behavioral.observer.observer;

public class SecurityLoggingObserver implements SecurityObserver {

	@Override
	public void notify(int device, int event) {
		System.out.println("SecurityObserver.notify("+device+","+event+")");
	}

}
