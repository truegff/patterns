package ge.lanmaster.pattern;

class TBCPayer extends Payer {
	
	TBCPayer(PayableService service) {
		super(service);
	}

	@Override
	public boolean checkAmount(double amount) {
		if(amount > 0) {
			System.out.println("Amount cheking done successfuly");
			return true;			
		} else {
			System.out.println("There is NOT enough money on account");
			return false;
		}		
	} 
}
