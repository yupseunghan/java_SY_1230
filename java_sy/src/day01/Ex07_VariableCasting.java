package day01;

public class Ex07_VariableCasting {

	public static void main(String[] args) {
		//업캐스팅
		double num1 =1;
		int num2='A';
		long num3 =1234;
		System.out.println(num1+"\n"+num2+"\n"+num3);
		
		//강제 : 데이터 손실이 발생할 수 있기 때문에
		int num4 =(int)3.14;
		int num5=(int)123L;
		
		System.out.println(num4+"\n"+num5);
		double res=(double)1/2;
		System.out.println(res);
	}
}
