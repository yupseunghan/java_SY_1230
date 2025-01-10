package day08;

import lombok.AllArgsConstructor;

public class Ex09_Objdect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		System.out.println(p);
		System.out.println(p.toString());
		
	}
	
}

class Point{
	int x,y;
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}