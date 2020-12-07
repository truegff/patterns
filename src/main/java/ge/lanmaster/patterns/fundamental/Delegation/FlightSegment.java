package ge.lanmaster.patterns.fundamental.Delegation;

public class FlightSegment {
	private LuggageCompartment luggage;

	public FlightSegment() {
		this.luggage = new LuggageCompartment();
	}

	void checkLuggage(Luggage piece) throws LuggageException {
		luggage.checkLuggage(piece);
		System.out.println("Luggage check step 2 ...");
	}

}


