package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex_Sche {
	/*
	 * 1. 스케줄 등록
	 * -날짜, 시작시간 
	 * 2. 스케줄 수정
	 * -날짜입력 > 해당 날짜 등록된 스케줄 출력 > 수정할 스케줄 선택 > 날짜 시간 할일 입력 하여 수정
	 * 3.스케줄 삭제
	 * -날짜입력 > 해당 날짜 등록된 스케줄 출력 > 삭제할 스케줄 선택하여 삭제
	 * 4.스케줄 조회
	 * -월 조회
	 * 	-년과 월을 입력받아 스케줄 조회
	 * -일 조회
	 * - 년 월 일을 입력받아 스케줄 조회
	 */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		char menu;
		do {
			printMenu();
			menu=sc.next().charAt(0);
			runMenu(menu);
		}while(menu != '5');
	}
	private static void runMenu(char menu) {
		List<Schedul> list = new ArrayList<>();
		switch(menu) {
		case'1': insertSchedul(list); break;
		case'2':updateSchedul(list);break;
		case'3':delSchedul(list);break;
		case'4':searchSchedul(list);break;
		default:System.out.println("잘못된 메뉴 선택ㅡㅡ");
		}
	}
	private static void printSearchMenu() {
		System.out.print("-----------------\n"
				+ "1.월 조회\n2.일 조회\n"
				+ "-----------------\n메뉴선택: ");
	}
	private static void searchSchedul(List<Schedul> list) {
		printSearchMenu();
		int menu =sc.nextInt();
		runSearch(menu,list);
	}

	private static void runSearch(int menu,List<Schedul> list) {
		switch(menu) {
		case 1:
			searchMonth(list);
			break;
		case 2:
			searchDay(list);
			break;
		default:System.out.println("올바른 메뉴가 아닙니다");
		}
	}
	private static void searchDay(List<Schedul> list) {
		System.out.print("날짜(XXXX-XX-XX): ");
		sc.nextLine();
		String date = sc.nextLine();
		List<Schedul> tmpList = list.stream()
				.filter(s->s.getDateStr().substring(0,10).equals(date))
				.collect(Collectors.toList());
		if(tmpList.size()==0) {
			System.out.println("검색 결과 없음");
			return;
		}
		for(Schedul sc : tmpList) {
			System.out.println(sc.toString());
		}
	}
	private static void searchMonth(List<Schedul> list) {
		System.out.print("날짜(XXXX-XX): ");
		sc.nextLine();
		String date = sc.nextLine();
		List<Schedul> tmpList = list.stream()
				.filter(s->s.getDateStr().substring(0,7).equals(date))
				.collect(Collectors.toList());
		if(tmpList.size()==0) {
			System.out.println("검색 결과 없음");
			return;
		}
		/*for(Schedul sc : tmpList) 
			System.out.println(sc.toString());*/
		list.stream().forEach(s->System.out.println(s));
	}
	private static void delSchedul(List<Schedul> list) {
		System.out.print("날짜 입력: ");
		String date = sc.nextLine();
		List<Schedul> tmpList = 
				list.stream()
				.filter(s->s.checkDate(date))
				.collect(Collectors.toList());
		if(tmpList.size()==0) {
			System.out.println("검색결과 없음");
			return;
		}
		for(int i=0;i<tmpList.size();i++) 
			System.out.println(i+1+". "+tmpList.get(i));
		System.out.print("삭제할 번호 선택: ");
		int index = sc.nextInt()-1;
		if(index<0||index>=tmpList.size()) {
			System.out.println("번호 잘못 입력");
			return;
		}
		tmpList.remove(index);
		System.out.println(tmpList.get(index).toString()+" 삭제");
	}
	private static void updateSchedul(List<Schedul> list) {
		System.out.print("날짜 입력: ");
		String date = sc.nextLine();
		List<Schedul> tmpList = 
				list.stream()
				.filter(s->s.checkDate(date))
				.collect(Collectors.toList());
		if(tmpList.size()==0) {
			System.out.println("검색결과 없음");
			return;
		}
		for(int i=0;i<tmpList.size();i++) 
			System.out.println(i+1+". "+tmpList.get(i));
		System.out.print("수정할 번호 선택: ");
		int index = sc.nextInt()-1;
		if(index<0||index>=tmpList.size()) {
			System.out.println("번호 잘못 입력");
			return;
		}
		try {
			Schedul schedul =inputSchedul();
			tmpList.get(index).update(schedul);
			System.out.println("바뀐 일정: "+tmpList.get(index).toString());
		} catch (ParseException e) {
			System.out.println("날짜 또는 시간을 잘못 입력하셨어요");
		}
		
	}
	private static Schedul inputSchedul() throws ParseException {
		System.out.print("날짜(XXXX-XX-XX): ");
		sc.nextLine();
		String date = sc.nextLine();
		System.out.print("시간(XX:XX): ");
		String time= sc.nextLine();
		System.out.print("할 일: ");
		String todo=sc.nextLine();
		return new Schedul(date+" "+time,todo);
	}
	private static void insertSchedul(List<Schedul> list) {
		try {
			Schedul schedul = inputSchedul();
			list.add(schedul);
		} catch (ParseException e) {
			System.out.println("날짜 또는 시간을 잘못 입력하셨습니다");
		}
	}
	private static void printMenu() {
		System.out.print("================="
				+ "\n1.스케줄 등록\n2.스케줄 수정\n3.스케줄 삭제\n4.스케줄 조회\n5.종료"
				+ "\n================="
				+ "\n메뉴 선택: ");
	}
}
@Data
@AllArgsConstructor
class Schedul{
	private Date date;
	private String todo;
	
	public void setDate(String dateTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.date=format.parse(dateTime);
	}
	public void update(Schedul schedul) {
		if(schedul==null)
			return;
		this.date=schedul.date;
		this.todo=schedul.todo;
	}
	public boolean checkDate(String date) {
		if(date == null || this.date == null)
			return false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String tmpDate = format.format(this.date);
		return tmpDate.equals(date);
	}
	public String getDateStr() {
		if(date == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(date);
	}
	@Override
	public String toString() {
		return "["+getDateStr()+"] 할일: "+todo;
	}
	public Schedul(String dateTime, String todo) throws ParseException {
		setDate(dateTime);
		this.todo=todo;
	}

}