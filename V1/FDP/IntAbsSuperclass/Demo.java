class Demo {
	public static void main(String[] args) {
		System.out.println("Interface and Abstract Class");
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		System.out.println(mc1.toString());
		System.out.println(mc2.toString());
		
	}
}
interface DoubleLinkIF {
	public DoubleLinkIF getNext();
	public void setNext(DoubleLinkIF newValue);
	public DoubleLinkIF getPrev();
	public void setPrev(DoubleLinkIF newValue);
}
abstract class AbstractDoubleLink implements DoubleLinkIF {
	private DoubleLinkIF prev;
	private DoubleLinkIF next;
	
	public DoubleLinkIF getNext() {	return next; }
	public void setNext(DoubleLinkIF newValue) { next = newValue; }
	public DoubleLinkIF getPrev() { return prev; }
	public void setPrev(DoubleLinkIF newValue) { prev = newValue; }
}
class MyClass1 extends AbstractDoubleLink {
	public String toString() {
		return "myClass1";
	}
}
class MyClass2 extends AbstractDoubleLink {
	public String toString() {
		return "myClass2";
	}
}