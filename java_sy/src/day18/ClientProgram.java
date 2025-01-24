package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientProgram {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Scanner sc;
	
	public ClientProgram(Socket socket) {
		this.socket = socket;
		this.sc = new Scanner(System.in);
		
		if(socket == null) {
			return;
		}
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		}catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public void run() {	
		if(socket == null || ois == null || oos == null) {
			System.out.println("[서버 연결에 실패했습니다.]");
			return;
		}
		
		int menu;
		do {
			printMenu();
			
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != 3);
	}

	private void printMenu() {
		System.out.println("------------------");
		System.out.println("1. 접속");
		System.out.println("2. 계좌건설");
		System.out.println("3. 종료");
		System.out.print("메뉴 입력: ");
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			login();
			break;
		case 2:
			open();
			break;
		case 3:
			break;
		default:
		}
		
	}

	private void login() {		
		Account account = inputAccount();
		System.out.println("[접속 중]");
		System.out.println("[같은 계정으로 다른 사용자가 먼저 사용중이면 대기할 수 있습니다.]");
		//서버와 통신해서 account가 일치하는지 확인 => 서버에게 account왈 이치하는 계좌 정보를 달라고 요청
		try {
			oos.writeInt(0);
			oos.flush();
			account = (Account)ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//일치하지 않으면 안내문구 후 종료
		
		System.out.println("[계좌에 접속했습니다.]");
		int menu=0;
		do {
			try {
				printLoginMenu();
				
				menu = sc.nextInt();
				sc.nextLine();
				
				runLoginMenu(menu, account);
			} catch (InputMismatchException e) {
				System.out.println("[메뉴는 숫자입니다]");
				sc.nextLine();
			}catch (Exception e) {
				System.out.println("[예외 발생]");
			}			
		}while(menu != 4);	
	}

	private Account inputAccount() {
		String bankName;
		//올바른 은행을 입력하기 전까지 계속 실행
		do {
			Bank.printBank();
			System.out.print("은행: ");
			bankName=sc.nextLine();
		}while(Bank.check(bankName));
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("비번: ");
		String pw = sc.nextLine();
		return null;
	}

	private void printLoginMenu() {
		// TODO Auto-generated method stub
		
	}

	private void runLoginMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			deposit(account);
			break;
		case 2:
			withdrawal(account);
			break;
		case 3:
			check(account);
			break;
		case 4:
			break;
		default:
		}
		
	}

	private void deposit(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void withdrawal(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void check(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void open() {
		//은행 이름 계좌번호 비밀번호
		String bankName;
		//올바른 은행을 입력하기 전까지 계속 실행
		do {
			Bank.printBank();
			System.out.print("은행: ");
			bankName=sc.nextLine();
		}while(Bank.check(bankName));
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("비번: ");
		String pw = sc.nextLine();
		System.out.print("비번확인: ");
		String pw2 = sc.nextLine();
		System.out.print("비번확인: ");
		String num = sc.nextLine();
		if(!pw.equals(pw2)) {
			System.out.println("[비번과 비번확인이 일치하지 않습니다]");
			return;
		}
		Bank bank = Bank.valueOf(bankName);
		Account account = new Account(bank,num,name,pw);
		try {
			//서버에 메뉴를 전송
			oos.writeInt(0);
			//서버에게 계좌번호를 전송
			oos.writeObject(account);
			oos.flush();
			if(ois.readBoolean())
				System.out.println("[계좌번호를 등록했습니다]");
			else
				System.out.println("[계좌번호 등록 실패]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}