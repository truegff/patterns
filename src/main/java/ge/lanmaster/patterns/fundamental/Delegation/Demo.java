package ge.lanmaster.patterns.fundamental.Delegation;

public class Demo {
	public static void main(String... args) {
		FlightSegment fs = new FlightSegment();
		try {
			fs.checkLuggage(new Luggage());
		} catch (LuggageException e) {
			System.out.println("Exception catchedmana " + e);
		}
	}
}
