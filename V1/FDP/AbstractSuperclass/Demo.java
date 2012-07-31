class Demo {
	public static void main(String[] args) {
		System.out.println("******");
		String1 s1 = new String1();
		String2 s2 = new String2();
		System.out.println(s1.toString1()+" "+s2.toString1());
		System.out.println("******");
	}
}
abstract  class AbstractString{
	public final String toString() {
		return "Abstract String";
	}
}
class String1 extends AbstractString{
	public String toString1() {
		return "String1";
	}
}
class String2 extends AbstractString{
	public String toString1() {
		return "String2";
	}
}
