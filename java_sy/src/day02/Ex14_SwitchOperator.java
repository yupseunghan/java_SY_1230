package day02;
import java.util.Scanner;

public class Ex14_SwitchOperator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res =0;
		System.out.println("두정수와 산술연산자 하나를 입력하세요");
		int n1 = sc.nextInt();
		char op=sc.next().charAt(0);
		int n2 = sc.nextInt();
		
		switch(op) {
		case '+':res=n1+n2; break;
		case '-':res=n1-n2; break;
		case '*':res=n1*n2; break;
		case '/':res=n1/n2; break;
		case '%':res=n1%n2; break;
		default : System.out.println("잘못된 연산식");
		}
		System.out.println(""+n1+op+n2+" = "+res);
	}
}
