package day10;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Ex13_Phone {
	/*전화번호 관리하는 프로그램
	 * 1.전화번호 추가
	 * 	-이름과 전화번호를 입력받아 추가
	 * 	-동명이인이 있을 수 있기 때문에 중복되도 추가
	 * 2.전화번호 수정
	 * 	-이름을 입력
	 * 	-이름과 일치화는 목록을 출력
	 * 	-수정하려는 전화번호를 선택
	 * 	-새 전화번호 입력받아 수정
	 * 3.전화번호 삭제
	 * 	-이름을 입력
	 * 	-이름과 일치하는 목록 출력
	 * 	-삭제하려는 전화번호를 선택 ex)1.한요한:321 2.한요한:321 선택:2
	 * 	-선택한 전화번호를 삭제
	 * 4.전화번호 조회
	 * 	- 이름을 입력
	 * 	-이름이 포함된 전화번호를 출력
	 * 5.종료*/

	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Phone> phone = new ArrayList<>();
		runMenu(phone);
	}
	private static void runMenu( ArrayList<Phone> phone) {
		char menu;
		do {
			menulist();
			menu= sc.next().charAt(0);
			switch(menu) {
			case '1' : insertPhone(phone);break;
			case '2' :updatePhone(phone); break;
			case '3' :delPhone(phone);break;
			case '4' :checkPhone(phone); break;
			case '5' :System.out.println("종료합니다"); return;
			default:System.out.println("잘못된 메뉴선택");
			}
		}while(menu != '5');
	}
	private static void delPhone(ArrayList<Phone> phone) {
		ArrayList<Phone> p = checkPhone(phone);
		
	}
	private static void updatePhone(ArrayList<Phone> phone) {
		
	}
	private static ArrayList<Phone> checkPhone(ArrayList<Phone> phone) {
		ArrayList<Phone> p = new ArrayList<Phone>();
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		int num=1;
		boolean found = false;
		for(int i=0;i<phone.size();i++) {
			if(phone.get(i).getName().contains(name)) {
				p.add(phone.get(i));
				System.out.println(num++ +". "+p.toString());
				found=true;
			}
		}
		if(!found)
			System.out.println("이름을 찾을 수 없다");
		return p;
	}
	private static void insertPhone(ArrayList<Phone> phone) {
		System.out.println("전화번호 추가");
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("전화번호(-는 빼고 입력 바람): ");
		String phoneNum = sc.nextLine();
		phone.add(new Phone(name,phoneNum));
		System.out.println("입력 완료");
	}
	private static void menulist() {
		System.out.println("-----------\n1.전화번호 추가\n2.전화번호 수정\n3.전화번호 삭제\n4.전화번호 조회\n5.종료");
		System.out.print("메뉴선택: ");
	}
}
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Phone{
	private String name, phoneNum;
	@Override
	public String toString() {
		return name+" : "+phoneNum;
	}
}