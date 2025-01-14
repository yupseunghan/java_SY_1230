package day11;

public class Ex01_Lamda {

	public static void main(String[] args) {
		//인터페이스의 객체를 생성하기 위해 구현 클래스를 선언 후 구현 크랠스의 객체를 생성
		MyMathClass mc = new MyMathClass();
		System.out.println(mc.max(1, 2));
		/* 인터페이스의 객체를 생성하기 위해 익명 클래스를 선언 후 객체를 생성*/
		MyMath mc2 = new MyMath() {
			@Override
			public int max(int num1, int num2) {
				return num1>num2?num1:num2;
			}			
		};
		System.out.println(mc2.max(1, 2));
		
		//인터페이스의 객체를 생성하기 위해 익명클래스를 선언 후 객체를 생성 : 람다식
		MyMath mc3 = (num1,num2)->{
			return num1>num2?num1:num2;
		};
		System.out.println(mc3.max(1, 2));
		
		Abs abs = (num)->{
			return num <0 ? -num : num;
		};
		System.out.println(abs.abs(-12));
	}
}
interface Abs{
	int abs(int num);
}
interface MyMath{
	int max(int num1,int num2);
}
class MyMathClass implements MyMath{

	@Override
	public int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}
	
}