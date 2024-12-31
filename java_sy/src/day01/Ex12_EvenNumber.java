package day01;
//변수 활용
public class Ex12_EvenNumber {

	public static void main(String[] args) {
		int num =3;
		boolean isEven=num%2==0;
		System.out.println(num+"은 짝수 인가? "+isEven);
		num++;
		System.out.println(num+"는 짝수 인가?"+isEven);
	}
}
