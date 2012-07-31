package ge.lanmaster.patterns.Prototype;

import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App 
{
    private Vector prototypes = new Vector();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        App app = new App();
        app.registerPrototype(new Prototype());
    }

    public void registerPrototype(Prototype prototype){
        System.out.println("PrototypePattern Client->registerPrototype(Prototype prototype); call executed");
        prototypes.addElement(prototype);
    }

    Prototype getRandomPrototype() {
        int i = (int) (prototypes.size() * Math.random());
        Prototype p = (Prototype) prototypes.elementAt(i);
        return (Prototype)p.clone();
    }
}