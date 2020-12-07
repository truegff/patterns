package ge.lanmaster.patterns.structural.Bridge.pattern.pay.payable;

public class GeocellPayableService implements PayableService {

	@Override
	public boolean processPayment(double amount, String subscriberNumber) {
		System.out.println("Geocell received " + amount + " GEL successfully");
		return true;
	}

	@Override
	public boolean checkSubscriber(String subscriberNumber) {
		System.out.println("Geocell check result: " + subscriberNumber + " number exists");
		return true;
	}

}
