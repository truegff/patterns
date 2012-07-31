package ge.lanmaster.patterns.ReadOnlyInterface;

import java.util.ArrayList;

public class TemperatureData implements TemperatureIF{
    private double temperature;
    private ArrayList listeners = new ArrayList();

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        fireTemperature();
    }

    public double getTemperature(){
        return temperature;
    }

    public void addListener(TemperatureIF listener) {
        listeners.add(listener);
    }

    public void removeListener(TemperatureIF listener) {
        listeners.remove(listener);
    }

    private void fireTemperature() {
        System.out.println("fireTemperature() executed");
        //int count = listeners.size();
/*        TemperatureEvent evt;
        evt = new TemperatureEvent(this, temperature);

        for (int i = 0; i < count; i++) {
            TemperatureListener thisListener = (TemperatureListener)listeners.get(i);
            thisListener.temperatureChanged(evt);
        }*/
    }
}
