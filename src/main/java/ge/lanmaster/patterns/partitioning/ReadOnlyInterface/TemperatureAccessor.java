package ge.lanmaster.patterns.partitioning.ReadOnlyInterface;

public interface TemperatureAccessor {

	double getTemperature();

	void addListener(TemperatureAccessor listener);

	void removeListener(TemperatureAccessor listener);

}
