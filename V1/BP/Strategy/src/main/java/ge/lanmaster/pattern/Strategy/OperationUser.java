package ge.lanmaster.pattern.Strategy;

/**
 * @author alexander
 */
public class OperationUser {
    public Double doSomething(Double x, Double y) {
        if (x > y) return new ExtractOperation().operation(x, y);
        return new SumOperation().operation(x, y);
    }
}
