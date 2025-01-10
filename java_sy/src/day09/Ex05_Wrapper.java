package day09;

public class Ex05_Wrapper {
	public static void main(String[] args) {
		int num1=10;
		Integer num2= num1; // 박싱 기본형 => 클래스
		int num3 = num2; // 언박싱. 클래스 => 기본형
		
		System.out.println(num2+","+num3);
		//언박싱 경우 null을 유의
		
		num2 = null; // 래퍼 클래스는 클래스이기에 null을 저장 가능
		//num3=num2; //예외 발생 null을 정수로 만들 수 x
	}
}
