package day10;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Ex02_List2 {

	public static void main(String[] args) {
		/* 클래스 형변환
		 * 구현 클래스(ArrayList)의 객체를 인터페이스(List)로 자동 클래스 형변환 할 수 있다
		 * */
		List<Point> list = new ArrayList<>();
		list.add(new Point(1,1));
		list.add(new Point(1,2));
		System.out.println(list);
		
		//get을 이용해서 주소를 가져올 수 있다
		//전달받은 객체 p와 list의 0번지에 있는 개체가 같은 객체
		Point p = list.get(0);
		//p를 수정하면 list에 있는 값도 수정이 됨
		p.setX(10);
		p.setY(10);
		System.out.println(list);
		
		/* list에 있는 값을 가져와서 수정할 때 list에는 반영하지 않고 싶을때*/
		Point p2 = new Point(list.get(1));
		p2.setX(10);
		p2.setY(10);
		System.out.println(list);
	}
}
@Data
@AllArgsConstructor //모든 멤버변수 매개변수로 하는 생성자
@NoArgsConstructor // 기본 생성사
@Getter // 모든 멤버변수 게터
@Setter // 모든 멤버변수 세터
class Point{
	int x,y;
	public Point(Point p) {
		x=p.x;
		y=p.y;
	}
}