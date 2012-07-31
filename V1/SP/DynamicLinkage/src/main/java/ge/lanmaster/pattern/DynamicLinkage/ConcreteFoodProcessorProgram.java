package ge.lanmaster.pattern.DynamicLinkage;

/**
 * @author alexander
 */
public class ConcreteFoodProcessorProgram extends AbstractFoodProcessorProgram {

    /**
     * Return the name of this food processing program object.
     */
    public String getName() {
        return "Chocolate Milk";
    }

    /**
     * A call to this method tells a food processing program
     * to start doing whatever it is supposed to be doing.
     */
    public void start() {
        double weight = getEnvironment().weight();
        if (weight>120.0 && weight < 160.0)
            getEnvironment().mix(4);
    } // start()

} // class ConcreteFoodProcessorProgram
