package day02;
import java.util.Scanner;
public class Ex10_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력");
		int num = sc.nextInt();
		System.out.println(num+"을 입력하셨읍니다");
		
		System.out.println("실수 입력");
		double num2 = sc.nextDouble();
		System.out.println(num2+"을 입력하셨읍니다");
		
		System.out.println("단어 입력");
		String str = sc.next();
		System.out.println(str+"을 입력하셨읍니다");
		
		System.out.println("문자 입력");
		char c =sc.next().charAt(0);
		System.out.println(c+"을 입력하셨읍니다");
		
		sc.nextLine();//앞에 입력한 엔터를 없애야 nextLine이 정상 작동함
		System.out.println("문장 입력");
		String str2 =sc.nextLine();
		System.out.println(str2+"를 입력하셨읍니다");
	}

}
