package day10;

import java.util.HashSet;

public class Ex04_Set {

	public static void main(String[] args) {
		/* Set
		 * 	-Collection 인터페이스의 자식 인터페이스
		 * 	-중복 허용x, 순서 보장x
		 * HashSet
		 * 	-Set 인터페이스의 구현 클래스
		 * */
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(100);
		set.add(200);
		set.add(1);
		set.add(2);
		System.out.println(set);
		System.out.println(set.contains(10));
		System.out.println(set.remove(20));
		System.out.println(set);
	}
}
