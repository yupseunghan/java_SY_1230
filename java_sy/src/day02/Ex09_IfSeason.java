package day02;

public class Ex09_IfSeason {

	public static void main(String[] args) {
		int month=2;
		if(month<=0||month>13) System.out.println("잘못된 월");
		else if(month >= 3 && month<6) System.out.println("봄");
		else if(month >=6 && month <9) System.out.println("여름");
		else if(month >=9 && month <12) System.out.println("가을");
		else System.out.println("겨울");
	}

}
