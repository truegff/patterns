package ge.lanmaster.patterns.Singleton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Singleton Pattern" );
        Singleton s = Singleton.getInstance();

        ObjectPreserver.preserveObject(s);

        Singleton.destroy();
        s.sayHello();

        ObjectPreserver.list();

        Singleton s2 = Singleton.getInstance();
        s2.sayHello();
        s2.sayHello();
        ObjectPreserver.list();
        s.sayHello();
        ObjectPreserver.unpreserveObject(s);
        ObjectPreserver.list();
    }
}
