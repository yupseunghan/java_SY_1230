package day06.score;

import java.util.Scanner;

public class StudentProgram{
	
	Scanner sc = new Scanner(System.in);
	public void run() {
		StudentManager sm = new StudentManager();
		char menu;
		do {
			input();
			menu=sc.next().charAt(0);
			runMenu(menu,sm);
		}while(menu != '3');
	}
	
	private void runMenu(char menu, StudentManager sm) {
		switch(menu) {
		case '1':
			sm=insertStudent(sm);
			break;
		case '2':
			sm.printStudent();
			break;
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 압니다.");
		}	
	}
	private StudentManager insertStudent(StudentManager sm) {
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("성적: ");
		int score = sc.nextInt();
		//학생 정보를 이용해서 객체 생성
		sm.insertStudent(name, score);
		return sm;
	}

	public void input() {
		System.out.println("메뉴");
		System.out.println("1. 학생 국어 성적 추가");
		System.out.println("2. 학생 국어 성적 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴선택: ");
	}
	
}
