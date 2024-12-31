package day02;

public class Ex13_SwitchSeason {

	public static void main(String[] args) {
		int month=7;
		switch(month) {
		case 1,2,12:System.out.println(month+"달은 겨울이에요"); break;
		case 3,4,5:System.out.println(month+"은 봄이에요"); break;
		case 6,7,8:System.out.println(month+"은 여름이에요"); break;
		case 9,10,11:System.out.println(month+"은 가을이에요"); break;
		default: System.out.println("그런 달은 없어요");
		}
	}

}
