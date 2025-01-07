package day06;

import java.util.Scanner;

public class Ex08_ReverseNumber {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n=0;
		for(;;) {
			System.out.println("4자리수 정수 입력바람");
			n = sc.nextInt();
			if(checkNumber(n, 4)) 
				break;
			else
				System.out.println("다시.");
		}
		int tmp = n;
		String str = Integer.toString(n);
		
		for(int i=str.length()-1;i>=0;i--) {
			char c = str.charAt(i);
			System.out.print(c);
		}
		System.out.println();
		while (tmp > 0) {
			System.out.print(tmp % 10);
			tmp /= 10;
		}
	}
	public static boolean checkNumber(int tmp,int size) {
		int min = 1*(int)Math.pow(10,size-1);
		//Math.pow(a,b) a의 b 제곱
		int max = 1*(int)Math.pow(10,size);
		if(tmp >= max || tmp < min)
			return false;
		return true;
	}
}
