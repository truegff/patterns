package ge.lanmaster.patterns.structural.Bridge.pattern.pay.payable;

public class TelasiPayableService implements PayableService {

	@Override
	public boolean processPayment(double amount, String subscriberNumber) {
		System.out.println("Telasi received " + amount + " GEL successfully");
		return true;
	}

	@Override
	public boolean checkSubscriber(String subscriberNumber) {
		System.out.println("Telasi check result: " + subscriberNumber + " subscriber number exists");
		return true;
	}

}
