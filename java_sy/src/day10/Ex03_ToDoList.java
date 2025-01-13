package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_ToDoList {
	static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		/* 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택: 1
		 * 등원
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택: 2
		 * 1.등원
		 * 삭제할 할일을 선택: 1
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택: 1 */
		ArrayList<String> list = new ArrayList<>();
		char menu;
		do {
			menuList();
			menu = sc.next().charAt(0);
			switch(menu) {
			case '1' : menuUp(list); break;
			case '2' : menuDel(list);break;
			case '3' : menuCheck(list);break;
			case '4' : System.out.println("종료합니다"); break;
			default: System.out.println("잘못된 메뉴선택입니다");
			}
		}while(menu != '4');
	}

	private static void menuCheck(ArrayList<String> list) {
		if(list.isEmpty()) {
			System.out.println("등록된 할일이 없음");
			return;
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(i+1+". "+list.get(i));
		}
	}

	private static void menuDel(ArrayList<String> list) {
		int index;
		menuCheck(list);
		System.out.println("삭제할 할일을 선택:");
		index = sc.nextInt() -1;
		if(index<0 || index>list.size()) {
			System.out.println("잘못된 선택");
			return;
		}else {
			list.remove(index);
			System.out.println("삭제완료");
		}
	}

	private static void menuUp(ArrayList<String> list) {
		System.out.print("등록: ");
		sc.nextLine();
		String work=sc.nextLine();
		list.add(work);	
	}

	private static void menuList() {
		System.out.println("1.할일 등록");
		System.out.println("2.할일 삭제");
		System.out.println("3.할일 조회");
		System.out.println("4.종료");
		System.out.print("메뉴선택 :");
	}
}
