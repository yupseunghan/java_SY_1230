package day07;

import java.util.Scanner;


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
			menulist("가계부 등록","가계부 수정","가게부 삭제","가계부 조회","종료");
			menu=sc.next().charAt(0);
			count = runMenu(menu, items, count);
		}while(menu!='5');
	}
	public static int runMenu(char menu, Item[] items, int count) {
		switch(menu) {
		case '1': count=insertItem(items, count);break;
		case '2': updateItem(items, count);break;
		case '3': count=deleteItem(items, count);break;
		case '4': checkItem(items,count);break;
		case '5':System.out.println("프로그램 종료합니다"); break;
		default: System.out.println("잘못된 선택");
		}
		return count;
	}

	public static int deleteItem(Item[] items, int count) {
		checkItem(items, count);
		System.out.println("삭제할 내역의 번호를 선택하세요");
		int index = sc.nextInt();
		for(int i=index-1;i<count;i++)
			items[i] = items[i+1];
		return count-1;
	}

	public static void updateItem(Item[] items, int count) {
		System.out.println("------------------");
		checkItem(items, count);
		System.out.print("수정할 내역의 번호를 선택 하세요");
		int index= sc.nextInt();
		if(items[index-1]==null||index > count||index<1) {
			System.out.println("번호를 잘못 입력 혹은 해당항목이 없습니다");
			return;
		}
			System.out.print("금액:");
			int money=sc.nextInt();
			items[index-1].update(money);
			System.out.println("수정 완료");
	}

	private static void checkItem(Item[] items, int count) {
		for(int i=0;i<count;i++) {
			items[i].print(i+1);
		}
	}
	public static Item inputItem() {
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
		Item item = new Item(income, type, content, money, date);
		return item;
	}
	public static int insertItem(Item[] items, int count) {
		items[count]=inputItem();
		return count+1;
	}

	private static void menulist(String ...menu) {
		System.out.println("---------------------------------------------");
	    System.out.println("메뉴");
	    for (int i = 0; i < menu.length; i++) {
	        System.out.println((i + 1) + ". " + menu[i]);
	    }
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
	public void update(int money) {
		this.money=money;
	}
	public void print() {
		System.out.println(income+"/"+type+"/"+content+"/"+money+"/"+date);
	}
	public void print(int n) {
		System.out.print(n+". ");
		print();
	}
	
}