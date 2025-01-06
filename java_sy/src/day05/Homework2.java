package day05;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		char menu;
		int minCount=0;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			menu =sc.next().charAt(0);
			minCount = runMenu(menu,minCount);
		}while(menu != '3');
	}
	
	public static int runMenu(char menu,int minCount) {
		switch(menu) {
		case '1': 
			int count = playGame();
			minCount = recordGame(minCount,count);
		case '2':
			
		}
		return minCount;
	}
	
	private static int recordGame(int minCount, int count) {
		if(minCount==0) return count;
		return minCount > count ? count : minCount;
	}
	
	private static int playGame() {
		Scanner sc = new Scanner(System.in);
		int mrandom,count=0;
		int max=100,min=1;
		int random = (int)(Math.random()*(max -min +1)+min);
		System.out.println(random);
		
		do {
			++count;
			System.out.print("입력: ");
			mrandom=sc.nextInt();
			if(random>mrandom) System.out.println("Up");
			else if(random < mrandom) System.out.println("Down");
			else System.out.println("정답이야 브로");
		}while(random!=mrandom);
		return count;
	}
	
	public static void printMenu() {
		System.out.println("메뉴\n 1.Updown 게임실행 \n 2.최고 기록 확인\n 3.프로그램 종료");
		System.out.print("메뉴 선택: ");
	}
	
	public static void printRecord(int minCount) {
		Scanner sc = new Scanner(System.in);
		if(minCount != 0)
			System.out.println("최고 기록: " + minCount);
		else System.out.println("게임을 실행한 적이 없습니다");
		System.out.print("메뉴로 가려면 엔터를 입력하세요.");
		sc.nextLine();
		sc.nextLine();
	}
}
