package ge.lanmaster.patterns.creational.Singleton;

public class Singleton {
	private static Singleton singleton;

	private Singleton() {
		System.out.println("Singleton constructor executed;");
	}

	synchronized public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	public void sayHello() {
		String s = new Integer(this.hashCode()).toString();
		System.out.println("Singleton sayHello(); executed." + s);
	}

	public static void destroy() {
		singleton = null;
	}
}
