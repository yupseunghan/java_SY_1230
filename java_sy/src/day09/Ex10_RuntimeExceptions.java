package day09;

public class Ex10_RuntimeExceptions {

	public static void main(String[] args) {
		int num1 =1, num2=0;
		try {
			//System.out.println(num1/num2); ArithmeticException
			/*Parent p = new Parent();
			Child c = (Child)p; ClassCastExertion 다운 캐스팅에서 발생*/
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
		print();

	}
	public static void print() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("예외 발생");
			return;
		}finally {
			System.out.println("메소드 종료");
		}
	}
}
class Parent{}
class Child extends Parent{}