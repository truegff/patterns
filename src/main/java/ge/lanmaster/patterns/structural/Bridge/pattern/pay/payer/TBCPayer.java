package ge.lanmaster.patterns.structural.Bridge.pattern.pay.payer;

import ge.lanmaster.patterns.structural.Bridge.pattern.pay.payable.PayableService;

public class TBCPayer extends Payer {

	public TBCPayer(PayableService service) {
		super(service);
	}

	@Override
	public boolean checkAmount(double amount) {
		if (amount > 0) {
			System.out.println("Amount cheking done successfuly");
			return true;
		} else {
			System.out.println("There is NOT enough money on account");
			return false;
		}
	}

}
