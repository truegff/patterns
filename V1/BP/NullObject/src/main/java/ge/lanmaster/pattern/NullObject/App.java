package ge.lanmaster.pattern.NullObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "NullObject Pattern" );
        BusinessRule br = new BusinessRule();
        WarningRouter wr = new WarningDialog();
        wr.routeWarning("asdf");
        wr = new IgnoreWarning();
        wr.routeWarning("asdf");
    }
}
