package day05;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char menu;
		int max=100,min=1;
		int maxCount = 0;
		do {
			System.out.println("메뉴\n 1.Updown 게임실행 \n 2.최고 기록 확인\n 3.프로그램 종료");
			System.out.print("메뉴 선택: ");
			menu=sc.next().charAt(0);
			switch(menu) {
			case '1':
				int mrandom,count=0;
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
				if(maxCount==0||maxCount > count) maxCount = count;
				break;
			
			case '2':
				if(maxCount != 0)
					System.out.println("최고 기록: " + maxCount);
				else System.out.println("게임을 실행한 적이 없습니다");
				System.out.print("메뉴로 가려면 엔터를 입력하세요.");
				sc.nextLine();
				sc.nextLine();
				break;
			case '3':System.out.println("프로그램 종료");break;
			default: System.out.println("올바른 메뉴가 아닙니다.");
			}
		}while(menu !='3'); {
			
		}
	}

}
