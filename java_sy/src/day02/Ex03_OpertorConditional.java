package day02;
import java.util.Scanner;
public class Ex03_OpertorConditional {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력해주세요 ");
		int num = sc.nextInt();
		String res = num%2==0 ? "짝수" : "홀수";
		System.out.println(num+"은 "+res);
	}
}
