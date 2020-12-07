package ge.lanmaster.patterns.partitioning.ReadOnlyInterface;

public class App {
	public static void main(String[] args) {
		System.out.println("ReadOnlyInterface Pattern");
		TemperatureData temperatureData = new TemperatureData();
		temperatureData.setTemperature(123);
		TemperatureAccessor tAccessor = temperatureData;
		System.out.println(tAccessor.getTemperature());

	}
}
