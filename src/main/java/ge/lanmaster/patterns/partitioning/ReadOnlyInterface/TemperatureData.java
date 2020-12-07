package ge.lanmaster.patterns.partitioning.ReadOnlyInterface;

import java.util.ArrayList;
import java.util.List;

public class TemperatureData implements TemperatureAccessor {

	private double temperature;
	private List<TemperatureAccessor> listeners = new ArrayList<>();

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		fireTemperature();
	}

	@Override
	public double getTemperature() {
		return temperature;
	}

	@Override
	public void addListener(TemperatureAccessor listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(TemperatureAccessor listener) {
		listeners.remove(listener);
	}

	private void fireTemperature() {
		System.out.println("fireTemperature() executed");
		int count = listeners.size();
		TemperatureEvent evt = new TemperatureEvent(this, 1, temperature);

		for (int i = 0; i < count; i++) {
			TemperatureAccessor listener = listeners.get(i);
//			listener.temperatureChanged(evt);
		}
	}

}
