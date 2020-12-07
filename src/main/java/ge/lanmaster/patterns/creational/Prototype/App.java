package ge.lanmaster.patterns.creational.Prototype;

import java.util.Vector;

public class App {
	private Vector<Prototype> prototypes = new Vector<Prototype>();

	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
		app.registerPrototype(new PrototypeImplementation());
	}

	public void registerPrototype(PrototypeImplementation prototype) {
		System.out.println("PrototypePattern Client->registerPrototype(Prototype prototype); call executed");
		prototypes.addElement(prototype);
	}

	PrototypeImplementation getRandomPrototype() {
		int i = (int) (prototypes.size() * Math.random());
		PrototypeImplementation p = (PrototypeImplementation) prototypes.elementAt(i);
		return (PrototypeImplementation) p.clone();
	}
}