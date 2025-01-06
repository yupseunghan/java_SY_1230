package day05;

public class Ex07_Initialize {

	public static void main(String[] args) {
		Point p = new Point();
		System.out.println(p.x1+", "+p.y1);
		System.out.println(p.x2+", "+p.y2);
		System.out.println(p.x3+", "+p.y3);
		System.out.println(p.x4+", "+p.y4);
	}

}
class Point{
	int x1,y1;
	int x2=1,y2=1;
	int x3=1,y3=1;
	int x4=1,y4=1;
	{
		x3=2;
		y3=2;
		x4=2;
		y4=2;
	}
	public Point() {
		x4=3;
		y4=3;
	}
	public int getX() {
		return x1;
	}

	public void setX(int x1) {
		this.x1 = x1;
	}

	public int getY() {
		return y1;
	}

	public void setY(int y1) {
		this.y1 = y1;
	}
}