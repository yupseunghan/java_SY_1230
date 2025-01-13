package day09;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Ex15_List {

	public static void main(String[] args) {
		/* List: 인터페이스
		 * ArrayList, LinkedList, Vector: List를 구현한 클래스
		 * - 순서 보장, 중복을 허용
		 * */
		ArrayList<Integer> list = new ArrayList<>(5);
		list.add(1);
		list.add(10);
		list.add(20);
		System.out.println(list);
		list.set(1,20);
		System.out.println(list);
		list.remove((Integer)20);
		System.out.println(list);
		System.out.println("현재 저장된 개수: "+list.size());
		
		ArrayList<Point> list2 = new ArrayList<Point>();
		
		list2.add(new Point(1,1));
		list2.add(new Point(10,10));
		
		System.out.println(list2);
		
		/* boolean remove(Object o)
		 * -이 remove는 같다를 Objects.equals를 이용하여 판단
		 * -Objects.equals(Objects o1,Objects o2)
		 * -o1과 o2가 다른 클래스이면 false를 리턴
		 * -o1과 o2가 같은 클래스이면 o1.equals를 이용하여 비교
		 * */
		list2.remove(new Point(1,1));
		list2.add(new Point(-1,-1));
		System.out.println(list2);
		
		//Iterator를 이용한 반복문 예제
		Iterator<Point> it = list2.iterator();
		System.out.println("-------");
		while(it.hasNext()) {
			Point tmp = it.next();
			System.out.println(tmp);
		}
		//Objects.equals를 이용하여 같은 객체를 찾아서 번지를 반환
		int index = list2.indexOf(new Point(-1,-1));
		System.out.println(index);
		
		//1번지에 있는 좌표 정보를 가져와서 2,3으로 수정하는 작업
		Point p = list2.get(1);
		p.x=2;
		p.y=3;
		System.out.println(list2);
	}
}
@ToString
@EqualsAndHashCode //모든 매계변수 비교 다르게 비교 하려 할땐 오버로딩
class Point{
	int x,y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}