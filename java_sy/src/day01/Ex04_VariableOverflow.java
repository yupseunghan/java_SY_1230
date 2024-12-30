package day01;

public class Ex04_VariableOverflow {

	public static void main(String[] args) {
		byte num1= 127;
		num1++;
		System.out.println(num1);
		
		byte num2 = -128;
		num2--;
		System.out.println(num2);
	}

}
