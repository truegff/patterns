package ge.lanmaster.patterns.structural.Bridge.pattern.pay.payer;

import ge.lanmaster.patterns.structural.Bridge.pattern.pay.payable.PayableService;

public class TerminalPayer extends Payer {

	public TerminalPayer(PayableService service) {
		super(service);
	}

	@Override
	public boolean checkAmount(double amount) {
		if (amount > 0) {
			System.out.println("Banknotes' cheking done successfuly");
			return true;
		} else {
			System.out.println("There are false banknotes in terminal");
			return false;
		}
	}

}