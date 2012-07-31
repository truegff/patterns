package ge.lanmaster.pattern.Observer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Observer Pattern" );

        SecurityNotifier sn = new SecurityNotifier();
        sn.AddObserver(new SecurityObserver() {
            public void notify(int device, int event) {
                System.out.println("SecurityObserver.notify("+device+","+event+")");
            }
        });

        SecurityMonitor sm = new SecurityMonitor();
        sn.AddObserver(new SecurityAdapter(sm));

        // works :)
        sn.notify(1,SecurityObserver.ALARM);

        System.out.println("");
        
        sn.notify(1,SecurityObserver.DIAGNOSTIC);

        System.out.println("");
        
        sn.notify(1,SecurityObserver.LOW_POWER);

    }
}
