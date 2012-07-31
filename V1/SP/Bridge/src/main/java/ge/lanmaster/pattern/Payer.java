package ge.lanmaster.pattern;

abstract class Payer {
	
	PayableService service;
	
	Payer(PayableService service) {
		this.service = service;
	}
	
	abstract boolean checkAmount(double amount);	
	
	final boolean pay(double amount, String subscriberNumber) {		
		boolean success;
		if(service.checkSubscriber(subscriberNumber) == true && checkAmount(amount) == true) {
			success = service.processPayment(amount, subscriberNumber);
			System.out.println("Payment done successfuly");
		} else {
			success = false;
			System.out.println("Payment error");
		}
		return success;
	}
}
