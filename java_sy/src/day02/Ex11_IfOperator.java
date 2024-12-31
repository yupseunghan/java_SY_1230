package day02;

import java.util.Scanner;

public class Ex11_IfOperator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res=0;
		System.out.println("정수 하나를 입력하세요");
		int n1=sc.nextInt();
		System.out.println("연산자 하나를 입력하세요");
		char op = sc.next().charAt(0);
		System.out.println("정수 하나를 입력하세요");
		int n2=sc.nextInt();
		
		System.out.println(""+n1+op+n2);
		if(op=='+') res=n1+n2;
		else if(op=='-') res=n1-n2;
		else if(op=='/') res=n1/n2;
		else if(op=='*') res=n1*n2;
		else if(op=='%') res=n1%n2;
		else System.out.println("잘못입력");
		System.out.println(res+" If문");
	}

}
