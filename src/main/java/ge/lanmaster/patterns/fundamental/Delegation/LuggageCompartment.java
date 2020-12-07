package ge.lanmaster.patterns.fundamental.Delegation;

import java.util.ArrayList;
import java.util.List;

public class LuggageCompartment {

	private List<Luggage> pieces = new ArrayList();

	public void checkLuggage(Luggage piece) throws LuggageException {
		pieces.add(piece);
		System.out.println("Luggage check step 1 ...");
	}

}
