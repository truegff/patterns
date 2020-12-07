package ge.lanmaster.patterns.structural.Bridge.pattern.pay.payer;

import ge.lanmaster.patterns.structural.Bridge.pattern.pay.payable.PayableService;

abstract class Payer {

	private final PayableService service;

	public Payer(PayableService service) {
		this.service = service;
	}

	public abstract boolean checkAmount(double amount);

	public final boolean pay(double amount, String subscriberNumber) {
		boolean success;
		if (service.checkSubscriber(subscriberNumber) == true && checkAmount(amount) == true) {
			success = service.processPayment(amount, subscriberNumber);
			System.out.println("Payment done successfuly");
		} else {
			success = false;
			System.out.println("Payment error");
		}
		return success;
	}

}
