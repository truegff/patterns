package ge.lanmaster.patterns.ReadOnlyInterface;

public interface TemperatureIF {
    public double getTemperature();
    public void addListener(TemperatureIF listener);
    public void removeListener(TemperatureIF listener);
}
