package day02;

public class Ex01_OperatorLogicall {

	public static void main(String[] args) {
		int score=80;
		boolean isB = (score < 90 && score >=80);
		System.out.println("성적 B ? "+isB);
		
		int age= 15;
		boolean isAdult=age>=20;
		System.out.println(age+"살은 성인입니까? "+isAdult);
		System.out.println(age+"살은 미성년자입니까? "+!isAdult);
		
		int n=10;
		boolean isPositive= n>=1 || n==0;
		System.out.println(n+"은 0이상인가 ? "+isPositive);
	}
}
