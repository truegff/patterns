package ge.lanmaster.patterns.fundamental.MarkerInterface;

public class Demo {
	public static void main(String[] args) {
		System.out.println("MarkerInterface Pattern");
		SomeClass sc = new SomeClass();
		MarkerInterface1 m1sc = new SomeClass();
		MarkerInterface2 m2sc = new SomeClass();
		//SomeClass2.ololo(sc);
		SomeClass2.ololo(m1sc);
		SomeClass2.ololo(m2sc);
	}
}


