package day02;

public class Ex12_SwitchEven {

	public static void main(String[] args) {
		int num=2;
		
		switch(num%4) {
		case 0: System.out.println(num+"은 짝수이다"); break;
		case 1: System.out.println(num+"은 홀수이다"); break;
		}
	}

}
