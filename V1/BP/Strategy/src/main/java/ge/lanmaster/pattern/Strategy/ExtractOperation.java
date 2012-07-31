package ge.lanmaster.pattern.Strategy;

/**
 * @author alexander
 */
public class ExtractOperation implements OperationIF {

    @Override
    public Double operation(Double x, Double y) {
        return x-y;
    }

}
