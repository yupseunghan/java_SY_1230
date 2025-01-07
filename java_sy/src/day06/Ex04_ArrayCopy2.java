package day06;

public class Ex04_ArrayCopy2 {

	public static void main(String[] args) {
		Point[] p = new Point[5];
		for(int i=0;i<p.length;i++) {
			p[i] = new Point(i,i);
		}
		printArr(p);
		//얕은 복사
		Point[] p2 =new Point[p.length];
		System.arraycopy(p, 0, p2, 0, p.length);
		
		System.out.println("----------");
		p[0].x=10;
		printArr(p2);
		//깊은 복사
		Point[] p3 =new Point[p2.length];
		for(int i=0;i<p.length;i++) {
			//얕운 복사랑 같다 ->p3[i] = p2[i];
			p3[i] = new Point(p2[i]);
		}
		System.out.println("----------");
		p2[0].x=100;
		printArr(p3);
	}
	public static void printArr(Point[] arr) {
		for(int i=0; i<arr.length;i++ )
			arr[i].print();
		System.out.println();
	}
}
class Point{
	int x,y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	Point(Point p){
		this(p.x,p.y);
		//위와 같다 x=p.x; y=p.y;
	}
	void print() {
		System.out.println("("+x+","+y+")");
	}
}