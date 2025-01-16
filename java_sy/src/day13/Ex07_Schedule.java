package day13;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;

public class Ex07_Schedule {
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
	static List<Schedule> list = new ArrayList<Schedule>();
	public static void main(String[] args) {
		int menu=0;
		final int EXIT=5;
		String fileName ="src/day13/schedule.txt";
		load(fileName,list);
		do {
			printMenu();
			try {
				menu=sc.nextInt();
				sc.nextLine();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("올바른 메뉴가 아니에요");
				sc.nextLine();
			}
		}while(menu!=EXIT);
		save(fileName,list);
	}


	private static void save(String fileName, List<Schedule> list2) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					oos.writeObject(list);
				} catch(Exception e) {
					System.out.println("저장 실패");
				}
	}


	private static void load(String fileName, List<Schedule> list2) {
		try(FileInputStream fos = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fos)) {
					List<Schedule> tmp = (List<Schedule>) ois.readObject();
					list.addAll(tmp);
				} catch(Exception e) {
					System.out.println("불러오기 실패");
				}
	}


	private static void runMenu(int menu) {
		switch(menu) {
		case 1: insertSchedule(); break;
		case 2: updateSchedule(); break;
		case 3: delSchedule(); break;
		case 4: searchSchedule(); break;
		case 5: System.out.println("프로그램 종료"); break;
		default:
		}
	}

	private static void searchSchedule() {
		printSearchMenu();
		int menu =sc.nextInt();
		
		runSearch(menu);
	}

	private static void runSearch(int menu) {
		switch(menu) {
		case 1:
			searchMonth();
			break;
		case 2:
			searchDay();
			break;
		default:System.out.println("올바른 메뉴가 아닙니다");
		}
	}


	private static void searchDay() {
		System.out.print("날짜(yyyy-MM-dd): ");
		String date =sc.nextLine();
		List<Schedule> tmpList =
				list.stream()
				.filter(s->s.getDateStr().substring(0,10).equals(date))
				.collect(Collectors.toList());
		if(tmpList.size()==0){
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		list.stream().forEach(s->System.out.println(s));	
	}


	private static void searchMonth() {
		System.out.print("날짜(yyyy-MM): ");
		sc.nextLine();
		String date =sc.nextLine();
		List<Schedule> tmpList =
				list.stream()
				.filter(s->s.getDateStr().substring(0,7).equals(date))
				.collect(Collectors.toList());
		if(tmpList.size()==0){
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		list.stream().forEach(s->System.out.println(s));		
	}


	private static void printSearchMenu() {
		System.out.print("-----------------\n"
				+ "1.월 조회\n2.일 조회\n"
				+ "-----------------\n메뉴선택: ");
	}


	private static void delSchedule() {
		System.out.print("날짜(yyyy-MM-dd): ");
		String date =sc.nextLine();
		//날짜와 일치하는 일정들을 가져와서 리스트에 저장
		List<Schedule> tmpList =
				list.stream()
				.filter(s->s.checkDate(date))
				.collect(Collectors.toList());
		if(tmpList.size() == 0) {
			System.out.println("검색 결과 x"); return;
		}
		for(int i=0;i<tmpList.size();i++)
			System.out.println(i+1+". "+tmpList.get(i).toString());
		//수정할 일정을 선택
		System.out.println("삭제할 일정: ");
		int index =sc.nextInt()-1;
		if(index<0||index>=tmpList.size()) {
			System.out.println("잘못된 일정을 선택");
			return;
		}
		
		Schedule tmp = tmpList.get(index);
		list.remove(tmp);
		System.out.println(tmp.toString()+" 일정을 삭제");
	}

	private static void updateSchedule() {
		System.out.print("날짜(yyyy-MM-dd): ");
		String date =sc.nextLine();
		//날짜와 일치하는 일정들을 가져와서 리스트에 저장
		List<Schedule> tmpList =
				list.stream()
				.filter(s->s.checkDate(date))
				.collect(Collectors.toList());
		if(tmpList.size() == 0) {
			System.out.println("검색 결과 x"); return;
		}
		for(int i=0;i<tmpList.size();i++)
			System.out.println(i+1+". "+tmpList.get(i).toString());
		//수정할 일정을 선택
		System.out.println("수정할 일정: ");
		int index =sc.nextInt()-1;
		
		if(index<0||index>=tmpList.size()) {
			System.out.println("잘못된 일정을 선택");
			return;
		}
		try {
			sc.nextLine();
			Schedule schedule = inputSchdule();
			tmpList.get(index).update(schedule);
			System.out.println("바뀐 일정: "+schedule.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("잘못된 날짜 입력");
		}

		
	}
	private static Schedule inputSchdule() throws ParseException {
		System.out.print("날짜(yyyy-MM-dd): ");
		String date =sc.nextLine();
		System.out.print("시간(HH:mm): ");
		String time =sc.nextLine();
		System.out.print("할 일: ");
		String toDo = sc.nextLine();
		return new Schedule(date+" "+time,toDo);
	}
	private static void insertSchedule() {
		try {
			Schedule schedule = inputSchdule();
			list.add(schedule);
			System.out.println("스케줄 등록");
		} catch (ParseException e) {
			System.out.println("잘못된 날짜와 시간을 입력");
		}
	}

	
	private static void printMenu() {
		System.out.print("-----------------\n"
				+ "1.스케줄 등록\n2.스케줄 수정\n3.스케줄 삭제\n4.스케줄 조회\n5.종료\n"
				+ "-----------------\n메뉴선택: ");
	}
}
@Data
class Schedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String toDo;
	public void setDate(String dateTime) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.date=format.parse(dateTime);
	}
	public void update(Schedule schedule) {
		if(schedule == null)
			return;
		this.date=schedule.date;
		this.toDo=schedule.toDo;
	}
	public Schedule(String dateTime, String toDo) throws ParseException {
		this.toDo=toDo;
		setDate(dateTime);
	}
	public boolean checkDate(String date) {
		if(date == null || this.date==null)
			return false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String tmpDate = format.format(this.date);
		return tmpDate.equals(date);
	}
	public String getDateStr() {
		if(date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	@Override
	public String toString() {
		
		return "["+getDateStr()+"] : " + toDo;
	}
}