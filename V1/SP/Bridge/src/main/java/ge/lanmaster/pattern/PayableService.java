package ge.lanmaster.pattern;

interface PayableService {
	boolean processPayment(double amount, String subscriberNumber);	
	boolean checkSubscriber(String subscriberNumber);
}
