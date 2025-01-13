package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex06_ListSort {

	public static void main(String[] args) {
		/* 리스트 정렬*/
		ArrayList<Integer> list= new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(1);
		list.add(3);
		System.out.println(list);
		
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);//내림차순
		Collections.sort(list);
		System.out.println(list);//오름차순
		
		/* sort 메소드는 Comparator 인터페이스의 구현 클래스의 객체가 필요
		 * => 구현 클래스의 메소드를 이용해서 정려하기 때문에
		 * 익명 클래스를 만들고, 익명 클래스의 객체를 생성해서 sort의
		 * 매개변수로 넘겨줌*/
		/*list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});*/
		list.sort((o1,o2)->o2-o1);//람다식, 위 코드와 동일한 결과
		System.out.println(list);
	}
}
