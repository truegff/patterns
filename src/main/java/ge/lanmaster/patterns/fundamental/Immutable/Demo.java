package ge.lanmaster.patterns.fundamental.Immutable;

public class Demo {
	public static void main(String[] args) {
		System.out.println("IMMUTABLE");
		Position p = new Position(0, 0);
		System.out.println(p.getX() + " " + p.getY());
		Position p1 = p.offset(1, 1);
		System.out.println(p.getX() + " " + p.getY() + " != " + p1.getX() + " " + p1.getY());
		p = p.offset(1, 1);
		System.out.println(p.getX() + " " + p.getY());
		p = p.offset(3, 6);
		System.out.println(p.getX() + " " + p.getY());

	}
}
