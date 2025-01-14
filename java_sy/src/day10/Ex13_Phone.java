package day10;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
	static ArrayList<Phone> phone = new ArrayList<>();
	public static void main(String[] args) {
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
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력
		//이름과 일치하는 전화번호 리스트 가져옴
		ArrayList<Phone> p = checkPhoneList(name);
		//검색결과 없으면 종료
		if(!printPhoneNumberList(p, false))return;
		//새로 만든 리스트를 이용하여 출력
		for(int i=0;i<p.size();i++) 
			System.out.println(i+1+". "+p.get(i));
		//삭제 번호 입력
		System.out.println("삭제할 번호 선택: ");
		int index = sc.nextInt()-1;
		//삭제할 전화번호 삭제
		//삭제한 번호-1번지에 있는 객체를 새로운 리스트에서 가져옴
		Phone pn = p.get(index);
		//가져온 객체를 기존 리스트에서 제거
		phone.remove(pn);//Object.equals()=>Object.equals
		System.out.println("전화번호가 삭제 되었습니다");
		
			
	}
	private static ArrayList<Phone> checkPhoneList(String name) {
		ArrayList<Phone> p = new ArrayList<Phone>();
		for(Phone pn : phone) {
			if(pn.getName().contains(name))
				p.add(pn);
		}
		return p;
	}
	private static void updatePhone(ArrayList<Phone> phone) {
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력
		//이름과 일치하는 전화번호 리스트 가져옴
		ArrayList<Phone> p = checkPhoneList(name);
		//새로 만든 리스트를 이용하여 출력
		for(int i=0;i<p.size();i++) 
			System.out.println(i+1+". "+p.get(i));
		//수정할 번호 입력
		System.out.println("수정할 번호 선택: ");
		int index = sc.nextInt()-1;
		//수정할 전화번호 수정
		//수정한 번호-1번지에 있는 객체를 새로운 리스트에서 가져옴
		Phone pn = p.get(index);
		//새 이름과 번호를 입력
		System.out.print("이름: ");
		sc.nextLine();
		String newName = sc.nextLine();
		System.out.print("전화번호(예: 000-0000-0000): ");
		String phoneNum = sc.nextLine();
		
		pn.update(newName,phoneNum);
		System.out.println("수정완료");
		
	}
	private static void checkPhone(ArrayList<Phone> phone) {
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();

		ArrayList<Phone> pList = checkPhoneList(name);
		printPhoneNumberList(pList, false);
	}
	private static void insertPhone(ArrayList<Phone> phone) {
		System.out.println("전화번호 추가");
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("전화번호(예: 000-0000-0000): ");
		String phoneNum = sc.nextLine();
		String regex ="^\\d{2,3}(-\\d{4}){2}$";
		if(!Pattern.matches(regex, phoneNum)) {
			System.out.println("올바른 전화번호가 아닙니다");
			return;
		}
		phone.add(new Phone(name,phoneNum));
		System.out.println("입력 완료");
	}
	private static void menulist() {
		System.out.println("-----------\n1.전화번호 추가\n2.전화번호 수정\n3.전화번호 삭제\n4.전화번호 조회\n5.종료");
		System.out.print("메뉴선택: ");
	}
	private static boolean printPhoneNumberList(ArrayList<Phone> pList,boolean isNum) {
		if(pList.size()==0 || pList==null) {
			System.out.println("결과가 없습니다");
			return false;
		}
		for(int i=0;i<pList.size();i++) {
			if(isNum) 
				System.out.print(i+1+". ");
			System.out.println(pList.get(i));
		}
		return true;
	}
}


@AllArgsConstructor
@Getter
@Setter
class Phone{
	private String name, phoneNum;
	@Override
	public String toString() {
		return name+" : "+phoneNum;
	}
	public void update(String newName, String phoneNum) {
		this.name=newName;
		this.phoneNum=phoneNum;
	}
}