package ge.lanmaster.pattern.VirtualProxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "VirtualProxy Pattern" );

        CabinetAssistantProxy cap = new CabinetAssistantProxy("abc");
        cap.operation1();
        cap.operation2();
    }
}
