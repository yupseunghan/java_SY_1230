package day01;

public class Ex03_VariableNumeber {

	public static void main(String[] args) {
		byte num1 =1;
		System.out.println(num1);
		
		int num2 =123456789;
		System.out.println(num2);
		
		long num3 =123456789012l;
		System.out.println(num3);
		
		float num4=3.14F;
		System.out.printf("%.9f\n",num4);//.n = 소수점 n자리까지
		
		double num5 = 3.14;
		System.out.printf("%.20f\n",num5);
		
		int num6 = 0x10/* 16진수 10 => 16*/, num7 = 010 /*8진수 10 => 8*/, num8 =0b10 /*2진수 10 =>2*/,num9= 'A'/*A에 해당되는 정수값 저장*/;
		
		double num10 =1e3;
	}

}
