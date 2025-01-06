package day05;

public class Ex05_Static2 {

	public static void main(String[] args) {
		
	}
}
class StaticTest{
	int a;
	static int sa;
	public void printA() {
		a=10;
		sa=10;
		System.out.println(a);
	}
	public static void printSa() {
		//a=10; 객체 변수는 정적 메소드에서 사용x
		StaticTest st = new StaticTest();
		st.a=10;
		sa=10;
		System.out.println(sa);
	}
	public void test() {
		printA();
		printSa();
	}
	public static void staticTest() {
		//printA(); 객체 메소드는 정적 메소드에서 사용 x 메소드 안에 객체 생성 후 사용 가능
		printSa();
	}
}