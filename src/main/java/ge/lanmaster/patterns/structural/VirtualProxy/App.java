package ge.lanmaster.patterns.structural.VirtualProxy;

public class App {
    public static void main( String[] args ) {
        System.out.println( "VirtualProxy Pattern" );

        CabinetAssistantProxy cap = new CabinetAssistantProxy("abc");
        cap.operation1();
        cap.operation2();
    }
}
