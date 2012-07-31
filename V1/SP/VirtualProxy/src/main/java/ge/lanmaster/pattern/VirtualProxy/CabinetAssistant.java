package ge.lanmaster.pattern.VirtualProxy;

/**
 * This is a service class that is used by a virtual proxy.
 * The noteworthy aspect of this class is that it implements an
 * interface written to declare the methods of this class
 * rather than the other way around.
 */
public class CabinetAssistant implements CabinetAssistantIF {

    public CabinetAssistant(String s) {
        System.out.println("Contructor("+s+")");
    } // Constructor(String)

    public void operation1() {
        System.out.println("Operation1");
    } // operation1()

    public void operation2() {
        System.out.println("Operation2");
    } // operation2()

} // class CabinetAssistant
