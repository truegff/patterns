package ge.lanmaster.patterns.structural.Bridge.pattern.pay.payable;

public interface PayableService {

	boolean processPayment(double amount, String subscriberNumber);

	boolean checkSubscriber(String subscriberNumber);

}
