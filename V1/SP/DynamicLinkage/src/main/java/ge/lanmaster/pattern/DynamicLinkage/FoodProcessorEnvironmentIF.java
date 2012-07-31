package ge.lanmaster.pattern.DynamicLinkage;

/**
 * @author alexander
 */
public interface FoodProcessorEnvironmentIF {
    /**
     * Make a slice of food of the given width.
     */
    public void slice(int width);

    /**
     * Mix food at the given speed.
     */
    public void mix(int speed);

    /**
     * Weight food.
     * @return the weight in ounces.
     */
    public double weight();
} // interface FoodProcessorEnvironmentIF
