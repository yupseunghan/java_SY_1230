package day09;

import javax.management.RuntimeErrorException;

public class Ex12_Exception {

	public static void main(String[] args) {
		try {
			test1();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
	public static void test1() {
		test2();
	}
	private static void test2() {
		test3();
	}
	private static void test3() {
		throw new RuntimeException("예외 발생");
	}
}
