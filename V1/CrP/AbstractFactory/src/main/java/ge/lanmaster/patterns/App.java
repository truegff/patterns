package ge.lanmaster.patterns;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ToolkitFactory myFactory;
        myFactory = ToolkitFactory.getInstance();
        ArchitectureToolkitIF af;
        af = myFactory.createToolkit(ToolkitFactory.EMBER);
        CPU cpu = af.createCPU();

    }
}
