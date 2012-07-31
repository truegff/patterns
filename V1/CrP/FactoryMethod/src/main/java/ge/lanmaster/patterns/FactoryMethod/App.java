package ge.lanmaster.patterns.FactoryMethod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("FactoryMethod Pattern");

        DocumentFactoryIF factory = new DocumentFactory1();
        DocumentIF document = factory.createDocument("type1");


        document.operation1();
        document.operation2();

        document = factory.createDocument("type2");

        document.operation1();
        document.operation2();
    }
}
