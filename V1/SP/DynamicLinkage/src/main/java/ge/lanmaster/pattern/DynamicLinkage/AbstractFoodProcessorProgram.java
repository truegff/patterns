package ge.lanmaster.pattern.DynamicLinkage;

/**
 * @author alexander
 */
public abstract class AbstractFoodProcessorProgram {

    private FoodProcessorEnvironmentIF environment;

    /**
     * The food processor environment passes a reference to
     * itself to this method. That allows instances of
     * subclasse of this class to call the methods of the
     * food processor environment object that implements the
     * FoodProcessorEnvironmentIF interface.
     */
    public void setEnvironment(FoodProcessorEnvironmentIF environment) {
        this.environment = environment;
    } // setEnvironment(FoodProcessorEnvironmentIF)

    /**
     * Allow subclasses to fetch the reference to the
     * environment.
     */
    protected FoodProcessorEnvironmentIF getEnvironment() {
        return environment;
    } // getEnvironment()

    /**
     * Return the name of this food processing program object.
     */
    public abstract String getName();

    /**
     * A call to this method tells a food processing program
     * to start doing whatever it is supported to be doing.
     */
    public abstract void start();
} // class AbstractFoodProcessorProgram

