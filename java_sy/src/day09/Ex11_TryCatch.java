package day09;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Ex11_TryCatch {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 메소드
		 * 예외 처리*/
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("입력:");
			int n1=sc.nextInt();
			char op=sc.next().charAt(0);
			int n2=sc.nextInt();
			double res=calculate(n1,op,n2);
			System.out.println("결과: "+res);
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다");
		}catch(RuntimeException e) {
			System.out.println(MessageFormat.format("결과: {0}", e.getMessage()));
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
		 
	}

	private static double calculate(int n1, char op, int n2) throws Exception {
	
			 switch(op) {
			 case '+': return n1+n2;
			 case '-': return n1-n2;
			 case '*': return n1*n2;
			 case '/':
				 if(n2==0)
					 return Double.POSITIVE_INFINITY;
				 return n1/(double)n2;
			 case '%': return n1%n2;
			 default: throw new Exception("산술 연산자가 아닙니다.");
			 }
	}

}
