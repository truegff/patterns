package ge.lanmaster.patterns.behavioral.Strategy.operation;

public class ExtractOperation implements Operation {

	@Override
	public Double operation(Double x, Double y) {
		return x - y;
	}

}
