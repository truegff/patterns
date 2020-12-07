package ge.lanmaster.patterns.creational.Singleton;

import java.util.HashSet;
import java.util.Iterator;

public class ObjectPreserver implements Runnable {

	private static ObjectPreserver lifeLine = new ObjectPreserver();

	private static HashSet protectedSet = new HashSet();

	private ObjectPreserver() {
		new Thread(this).start();
	}

	public synchronized void run() {
		try {
			wait();
		} catch (InterruptedException e) {

		}
	}

	public static void preserveObject(Object o) {
		System.out.println(new Integer(o.hashCode()).toString());
		protectedSet.add(o);
	}

	public static void unpreserveObject(Object o) {
		protectedSet.remove(o);
	}

	public static void list() {
		System.out.println("*** List ***");
		for (Iterator iterator = protectedSet.iterator(); iterator.hasNext(); ) {
			Object next = iterator.next();
			System.out.println(new Integer(next.hashCode()).toString());
		}
		System.out.println("*** List ***");
	}

}
