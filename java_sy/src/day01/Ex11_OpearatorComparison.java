package day01;

public class Ex11_OpearatorComparison {

	public static void main(String[] args) {
		String str1="abc", str2="abc";
		String str3 = new String("abc");
		int num1=1 ,num2=2;
		System.out.println(num1+" > "+num2+" ? "+(num1>num2));
		System.out.println(num1+" >= "+num2+" ? "+(num1>=num2));
		System.out.println(num1+" < "+num2+" ? "+(num1<num2));
		System.out.println(num1+" <= "+num2+" ? "+(num1<=num2));
		System.out.println(num1+" == "+num2+" ? "+(num1==num2));
		System.out.println(num1+" != "+num2+" ? "+(num1!=num2));
		
		System.out.println(str1+" == "+str2+" ? "+str1==str2);
		System.out.println(str1+" == "+str3+" ? "+str1==str3);
		System.out.println(str1+" == "+str2+" ? "+str1.equals(str2));
		System.out.println(str1+" == "+str3+" ? "+str1.equals(str3));
	}

}
