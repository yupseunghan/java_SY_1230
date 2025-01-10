package day08;

public class Ex06_Final {

	public static void main(String[] args) {
		/*
		 * final : 변하지 않은
		 * -변수: 변수가 변하지 않음 => 상수
		 * -메소드 : 메소드가 변하지 않음 => 오버라이딩 불가능
		 * - 클래스: 클래스가 변하지 않음 => 상속이 불가능
		 * */
	}
}
final class C1{}
class C2{
	public void test1(){}
	public final void test2() {}
}
//final 클래스는 부모클래스가 될 수 없다.class D1 extends C1{}
class D2 extends C2{
	@Override
	public void test1() {}
	//test2는 파이널이라 오버라이드 불가능
}