package ge.lanmaster.patterns.structural.DynamicLinkage;

public interface FoodProcessorEnvironmentIF {
    /**
     * Make a slice of food of the given width.
     */
    void slice(int width);

    /**
     * Mix food at the given speed.
     */
    void mix(int speed);

    /**
     * Weight food.
     * @return the weight in ounces.
     */
    double weight();
}
