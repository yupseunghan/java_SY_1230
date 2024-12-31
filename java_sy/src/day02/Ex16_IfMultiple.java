package day02;

import java.util.Scanner;

public class Ex16_IfMultiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 하나 입력: ");
		int n= sc.nextInt();
		if(n%6==0) System.out.println("6의 배수");
		else if(n%2==0) System.out.println("2의 배수");
		else if(n%3==0) System.out.println("3의 배수");
		else System.out.println("2,3,6의 배수가 아님");
		
		if(n%2==0) {
			if(n%3==0)System.out.println("6의 배수");
			else System.out.println("2의 배수");
		}else if(n%3==0) System.out.println("3의 배수");
		else System.out.println("2,3,6의 배수가 아님");
	}
}
