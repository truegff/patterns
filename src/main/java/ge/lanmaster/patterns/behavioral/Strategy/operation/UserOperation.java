package ge.lanmaster.patterns.behavioral.Strategy.operation;

import ge.lanmaster.patterns.behavioral.Strategy.operation.ExtractOperation;
import ge.lanmaster.patterns.behavioral.Strategy.operation.Operation;
import ge.lanmaster.patterns.behavioral.Strategy.operation.SumOperation;

public class UserOperation implements Operation {

	@Override
	public Double operation(Double x, Double y) {
		if (x > y) {
			return new ExtractOperation().operation(x, y);
		} else {
			return new SumOperation().operation(x, y);
		}
	}

}
