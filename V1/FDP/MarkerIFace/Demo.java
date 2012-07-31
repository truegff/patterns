class Demo {
	public static void main(String[] args) {
		System.out.println("MarkerInterface Pattern");
		SomeClass sc = new SomeClass();
		MarkerIF m1sc = new SomeClass();
		M2IF m2sc = new SomeClass();
		//SomeClass2.ololo(sc);
		SomeClass2.ololo(m1sc);
		SomeClass2.ololo(m2sc);
	}
}
interface MarkerIF {
}
interface M2IF {
}
class SomeClass implements MarkerIF, M2IF {
}
class SomeClass2 {
	public static void ololo(MarkerIF obj) {
		System.out.println("MarkerIF");
	}
	public static void ololo(M2IF obj) {
		System.out.println("M2IF");
	}
}