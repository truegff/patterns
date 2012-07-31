import java.util.ArrayList;

class FlightSegment { 
	LuggageCompartment luggage;
	void checkLuggage(Luggage piece) throws LuggageException { 
		luggage.checkLuggage(piece);
		System.out.println("Luggage check step 2 ...");
	}
	
	FlightSegment() {
		this.luggage = new LuggageCompartment();
	}
	
	public static void main(String[] args) {
		FlightSegment fs = new FlightSegment();
		try {
			fs.checkLuggage(new Luggage());
		} catch (LuggageException e) {
			System.out.println("Exception catchedmana "+e);
		}
	}
}

class LuggageCompartment {
	private ArrayList pieces = new ArrayList();
	void checkLuggage(Luggage piece) throws LuggageException { 
		pieces.add(piece);
		System.out.println("Luggage check step 1 ...");
	}
}

class LuggageException extends Exception{}
class Luggage{}