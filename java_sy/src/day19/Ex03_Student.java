package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex03_Student {
	static List<Student> list = new ArrayList<>();
	static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		/*학생들의 출석 관리 프로그램
		 * 1학생등록
		 * 이름만
		 * 2출석체크
		 * 날짜입력 등록된 학생 출석 여부 체크
		 * 2024-01-27
		 * 지각 조퇴없고 출석이면 o 결석 x
		 * 3출석확인
		 * 4종료*/
		
		runMenu();
	}

	private static void runMenu() {	
		int menu;
		do {
			printMenu();
			menu=sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				insertStudent();
				break;
			case 2:
				rollCall();
				break;
			case 3:
				verify();
				break;
			case 4:
				System.out.println("종료합니다");
				break;
			default:
				System.out.println("잘못된 메뉴");
			}
		}while(menu!=4);
		
	}

	private static void verify() {
		for(Student tmp : list) {
			System.out.println(tmp.toString());
		}
	}

	private static void rollCall() {
		System.out.print("날짜 입력: ");
		String str = sc.nextLine();
		if(!isDate(str)) {
			System.out.println("날짜를 다시 입력하세요");
			rollCall();
		}
		attCheck(str);
	}

	private static void attCheck(String str) {
		int count =1;
		char res;
		System.out.println("출석이면 o 결석이면 x");
		for(Student std : list) {
			System.out.print(count+++". "+std.getName()+" : ");
			res =sc.next().charAt(0);
			if(res != 'X' && res !='O') {
				System.out.println("출석 다시");
				attCheck(str);
			}
			check(std,res,str);
		}
	}


	private static void check(Student std, char res, String str) {
		int index = list.indexOf(std);
		list.set(index, new Student(std.getName(),new Check(str,isboolean(res))));
	}

	private static boolean isboolean(char res) {
		switch(res) {
		case 'O':return true;
		case 'X':return false;
		}
		return false;
	}

	private static boolean isDate(String str) {
		try {
			new SimpleDateFormat("yyyy-MM-dd").parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	private static void insertStudent() {
		System.out.print("이름 입력: ");
		String name=sc.nextLine();
		Student std = new Student(name);
		list.add(std);
		System.out.println("학생 등록 완료");
	}

	private static void printMenu() {
		System.out.println("1.학생 등록  2.출석체크  3.출석확인  4.종료");
		System.out.print("선택: ");
	}

}
