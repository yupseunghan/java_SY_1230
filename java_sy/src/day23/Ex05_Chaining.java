package day23;

import lombok.Data;

public class Ex05_Chaining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
@Data
class Point4{
	private int x,y;
	public void print1() {
		System.out.println(x+","+y);
	}
	public Point4 print2() {
		System.out.println(x+","+y);
		return this;
	}
}