class Demo {
	public static void main(String[] args) {
		System.out.println("IMMUTABLE");
		Position p = new Position(0, 0);
		System.out.println(p.getX()+" "+p.getY());
		Position p1 = p.offset(1, 1);
		System.out.println(p.getX()+" "+p.getY()+" != "+p1.getX()+" "+p1.getY());
		p = p.offset(1, 1);
		System.out.println(p.getX()+" "+p.getY());
		p = p.offset(3, 6);
		System.out.println(p.getX()+" "+p.getY());
		
	}
}
class Position {
	private int x;
	private int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public Position offset(int xOffset, int yOffset) {
		return new Position(x+xOffset, y+yOffset);
	}
}