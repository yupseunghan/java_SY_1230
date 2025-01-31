package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
	/* 쇼핑몰을 구현하세요.
	 * - 제품 관리
	 *  - 관리자가 관리
	 *  - 관리자는 admin/admin으로 고정
	 *  - 제품 추가, 수정, 삭제, 제품 입고
	 *	- 제품 추가
	 *	  - 제품 코드(6자리. ABC001), 분류, 제품명, 옵션, 가격을 등록
	 *	  - ABC001, 문구, 볼펜, 빨강, 1000
	 *	  - DEF001, 의류, 셔츠, XL, 30000
	 *	  - XYZ001, 식품, 우유 1L, 딸기, 2000
	 *	  - XYZ002, 식품, 딸기 우유, 1L, 2000
	 *	  - XYZ003, 식품, 딸기 우유, 2L, 3000
	 *	  - 분류는 문구, 의류, 식품, 가전, 기타로 고정
	 *	  - 각 분류마다 분류코드가 지정
	 *	    - 문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
	 *	  - 제품 코드는 분규 코드에 등록된 순서 3자리를 만들어서 총 6자리로 고정  
	 *	제품 입고
	 *	  - 제품 코드, 수량을 입력해서 제품을 입고    
	 * - 제품 구매
	 * 	- 등록된 제품을 선택 후 수량을 선택해서 구매
	 * 	- 로그인한 사용자가 제품을 구매할 수 있음. 
	 *  - 로그인하지 않으면 제품을 조회 및 구매할 수 없음
	 *  - 수량이 있는 제품만 구매 가능
	 *  - 제품 코드와 수량을 선택해서 구매
	 *  - 결제 과정은 없음(생략)
	 * - 제품 조회
	 *  - 분류를 이용하여 조회
	 *    - 문구, 의류, 식품, 가전, 기타, 전체
	 *  - 제품 코드, 제품명, 옵션, 수량, 가격이 조회
	 * - 회원가입
	 *  - 아이디, 비번, 비번확인을 입력해서 회원 가입
	 * - 로그인
	 *  - 아이디, 비번을 입력하여 회원이면 제품 조회로, 아니면 메인으로 돌아감
	 *  - 관리자이면 관리자 메뉴로 이동
	 * */
	/* 메인 메뉴
	 * 1. 로그인
	 * 2. 회원가입
	 * 3. 종료
	 * 
	 * 관리자 메뉴(로그인 시 관리자인 경우)
	 * 1. 제품 등록
	 * 2. 제품 수정
	 * 3. 제품 삭제
	 * 4. 제품 입고
	 * 5. 로그아웃
	 * 
	 * 사용자 메뉴(로그인 시 사용자인 경우)
	 * 1. 제품 조회
	 * 2. 로그 아웃
	 * 
	 * 제품 조회 메뉴
	 * 1. 문구 조회
	 * 2. 의류 조회
	 * 3. 식품 조회
	 * 4. 가전 조회
	 * 5. 기타 조회
	 * 6. 전체 조회
	 * 7. 이전으로
	 * 제품 상세 
	 * 제품 정보를 출력
	 * 1. 제품 구매
	 * 2. 이전으로
	 * */
	private static List<Product> list = new ArrayList<Product>();
	private static List<Member> members = new ArrayList<Member>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		members.add(new Member("admin","admin","관리자"));
		int menu=0;
		do {
			try {
				printMainMenu();
				menu=sc.nextInt();
				runMainMenu(menu);
			}catch (Exception e) {
				System.out.println("잘못된 메뉴");
				sc.nextLine();
			}
		}while(menu!=3);
	}
	private static void runMainMenu(int menu){
		switch(menu) {
		case 1:
			login();
			break;
		case 2:
			singUp();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다");
			break;
		default:
			System.out.println("잘못된 메뉴");
		}
	}
	private static void login() {
		Member member =signin();
		String autority=member.getAuthority();
		switch(autority) {
		case "사용자":
			userMenu();
			break;
		case "관리자":
			adminMenu();
			break;
		default:
			System.out.println("로그인 실패");
		}
	}
	private static void adminMenu() {
		int menu;
		do {
			System.out.print("1.제품 등록\n2.제품 수정\n3.제품 삭제\n4.제품 입고\n5.로그아웃\n선택: ");
			menu=sc.nextInt();
			runAdminMenu(menu);
		}while(menu != 5);
	}
	private static void runAdminMenu(int menu) {
		switch(menu) {
		case 1:
			productInsert();
			break;
		case 2:
			productUpdate();
			break;
		case 3:
			productDelete();
			break;
		case 4:
			productStore();
			break;
		case 5:
			System.out.println("로그아웃!");
			return;
		default:
			System.out.println("잘못된 선택..");
		}
	}
	private static void productStore() {
		System.out.print("수량입고 할 코드명을 입력: ");
		sc.nextLine();
		String code = sc.nextLine();
		int index = list.indexOf(new Product(code,"","",null,0));
		if(index < 0) {
			System.out.println("일치하는 제품이 없습니다");
			return;
		}
		Product p = list.get(index);
		System.out.print("입고할 수량: ");
		int store = sc.nextInt();
		p.amount(store);
		System.out.println("수량 변경 완료");
	}
	private static void productDelete() {
		System.out.print("삭제 할 코드명을 입력: ");
		sc.nextLine();
		String code = sc.nextLine();
		
		if(list.remove(new Product(code,"","",null,0)))
			System.out.println("제품 삭제 완료");
		else
			System.out.println("일피하는 제품이 없습니다");
	}
	private static void productUpdate() {
		
		System.out.print("수정 할 코드명을 입력: ");
		sc.nextLine();
		String code = sc.nextLine();
		int index = list.indexOf(new Product(code,"","",null,0));
		if(index < 0) {
			System.out.println("일치하는 제품이 없습니다");
			return;
		}
		Product oldP = list.get(index);
		System.out.println("==수정==");
		System.out.println("제품명: ");
		String name=sc.nextLine();
		System.out.println("옵션: ");
		String option=sc.nextLine();
		System.out.println("가격: ");
		int price=sc.nextInt();
		oldP.update(name,option,price);
		System.out.println("제품 수정 완료");
	}
	private static void productInsert() {
		System.out.println("==제품 등록==");
		Product np = productNew();
		list.add(np);
		System.out.println("제품 등록 완료!");
	}
	private static Product productNew() {
		System.out.print("제품 분류: ");
		sc.nextLine();
		String category =sc.nextLine();
		System.out.println("제품명: ");
		String name=sc.nextLine();
		System.out.println("옵션: ");
		String option=sc.nextLine();
		System.out.println("가격: ");
		int price=sc.nextInt();
		String codePrefix=Product.getCodePrefix(category);
		int max = getLastNum(list,codePrefix);
		return new Product(max,name,option,Category.valueOf(category),price);
	}
	private static int getLastNum(List<Product> list2, String codePrefix) {
		if(list==null)
			return -1;
		int max =0;
		for(Product p : list) {
			if(p.getCode().substring(0,3).equals(codePrefix)) {
				int num =Integer.parseInt(p.getCode().substring(3));
				if(max < num)
					max=num;
			}
		}
		return max;
	}
	private static Member signin() {
		String id,pw;
		System.out.print("아이디 입력: ");
		sc.nextLine();
		id=sc.nextLine();
		System.out.print("비밀번호 입력: ");
		pw=sc.nextLine();
		Member tmp = new Member(id, pw);
		for(Member m : members) {
			if(m.equals(tmp)) {
				System.out.println("로그인 성공");
				return m;
			}
		}
		tmp.setAuthority("");
		return tmp;
	}
	private static void singUp() {
		String id,pw,checkPw;
		boolean res;
		System.out.print("아이디 입력: ");
		sc.nextLine();
		id=sc.nextLine();
		res=duplicateId(id);
		if(res)
			return;
		System.out.print("비밀번호 입력: ");
		pw=sc.nextLine();
		System.out.print("비밀번호 확인: ");
		checkPw=sc.nextLine();
		if(!pw.equals(checkPw)) {
			System.out.println("비밀번호 확인을 다시 해주세요");
			return;
		}
		members.add(new Member(id, pw));
	}
	private static boolean duplicateId(String id) {
		boolean res= true;
		for(Member m : members) {
			if(m.getId().equals(id)) {
				System.out.println("아이디 중복");
				return res;
			}
		}return !res;
	}
	private static void printMainMenu() {
		System.out.println("----------------");
		System.out.println("1.로그인\n2.회원가입\n3.종료");
		System.out.println("----------------");
		System.out.print("메뉴 선택: ");
	}
	public static void userMenu() {
		int menu;
		do {
			System.out.print("1.제품 조회\n2.로그 아웃\n선택: ");
			menu=sc.nextInt();
			switch(menu) {
			case 1:productMenu(); break;
			case 2: System.out.println("로그아웃!");break;
			default:System.out.println("잘못된 선택ㅡㅡ");
			}
		}while(menu!=2);
	}
	private static void productMenu() {	
		int menu;
		Category category = null;
		do {
			System.out.print("1.문구 조회\n2.의류 조회\n3.식품 조회\n4.가전 조회\n5.기타 조회\n6.전체 조회\n7.이전으로\n선택: ");
			menu=sc.nextInt();
			switch(menu) {
			case 1: category=Category.문구; break;
			case 2: category=Category.의류; break;
			case 3: category=Category.식품; break;
			case 4: category=Category.가전; break;
			case 5: category=Category.기타; break;
			case 6: allProduct(); break;
			case 7:
				System.out.println("이전으로 돌아갑니다");
				return;
			default:System.out.println("잘못된 선택ㅡㅡ");
			}
			findProduct(category);
		}while(menu!=7);
	}
	
	private static void allProduct() {
		if(list.isEmpty()) {
			System.out.println("제품이 없습니다");
			return;
		}
		for(Product p: list) {
			System.out.println(p);
		}
	}
	
	private static void findProduct(Category category) {
		for(Product p : list) {
			if(category==p.getCategory()) {
				System.out.println(p);
			}
		}
	}
	
}
