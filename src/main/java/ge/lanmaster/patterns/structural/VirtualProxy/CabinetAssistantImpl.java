package ge.lanmaster.patterns.structural.VirtualProxy;

/**
 * This is a service class that is used by a virtual proxy.
 * The noteworthy aspect of this class is that it implements an
 * interface written to declare the methods of this class
 * rather than the other way around.
 */
public class CabinetAssistantImpl implements CabinetAssistant {

	public CabinetAssistantImpl(String s) {
		System.out.println("Contructor(" + s + ")");
	}

	public void operation1() {
		System.out.println("Operation1");
	}

	public void operation2() {
		System.out.println("Operation2");
	}

}
