package ge.lanmaster.patterns.ReadOnlyInterface;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "ReadOnlyInterface Pattern" );
        TemperatureData temperatureData = new TemperatureData();
        temperatureData.setTemperature(123);
        TemperatureIF tAccessor = temperatureData;
        System.out.println(tAccessor.getTemperature());
    }
}
