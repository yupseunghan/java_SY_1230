package day07;

import java.util.Scanner;

import day02.s;

/*
 * 메뉴
 * 1.가게부 등록
 * 2. 수정
 * 3.삭제
 * 4.조회
 * 5.종료
 * 선택 1
 * 수입/지출: 수입
 * 분류 : 월급
 * 내용: 1월 월급
 * 금액: 10000
 * 일시: 2025-01-08
 * 메뉴
 * 1.가게부 등록
 * 2. 수정
 * 3.삭제
 * 4.조회
 * 5.종료
 * 선택 2
 * 
 * */
public class Ex05_AccountBook {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int count =0;
		char menu;
		Item[] items = new Item[10];
		items[count++]= new Item("수입","연봉","초봉",3500,"2026-01-01");
		do {
			menulist();
			menu=sc.next().charAt(0);
			switch(menu) {
			case '1': count=insertItem(items, count);break;
			case '2': break;
			case '3': break;
			case '4': checkItem(items,count);break;
			case '5':System.out.println("프로그램 종료합니다"); break;
			default: System.out.println("잘못된 선택");
			}
		}while(menu!='5');
	}

	private static void checkItem(Item[] items, int count) {
		for(int i=0;i<count;i++) {
			items[i].print(i+1);
		}
	}

	public static int insertItem(Item[] items, int count) {
		System.out.print("수입/지출: ");
		String income=sc.next();
		
		System.out.print("분류: ");
		String type=sc.next();
		
		System.out.print("내용: ");
		sc.nextLine();
		String content=sc.nextLine();
		
		System.out.print("금액: ");
		int money = sc.nextInt();
		
		System.out.print("날짜:");
		sc.nextLine();
		String date=sc.nextLine();

		items[count]=new Item(income,type,content,money,date);
		return count+1;
	}

	private static void menulist() {
		System.out.println("---------------------------------------------");
		System.out.println("메뉴\n1. 가게부 등록\n2. 가게부 수정\n3. 가게부 삭제\n4. 가게부조회\n5. 프로그램 종료");
		System.out.print("메뉴 선택: ");
	}
}
class Item{
	private String income,type,content,date;
	private int money;
	public Item(String income,String type,String content,int money,String date) {
		this.income=income;
		this.type=type;
		this.content=content;
		this.money=money;
		this.date=date;
	}
	public void print() {
		System.out.println(income+"/"+type+"/"+content+"/"+money+"/"+date);
	}
	public void print(int n) {
		System.out.print(n+". ");
		print();
	}
	
}