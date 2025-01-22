package day15.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static Scanner sc = new Scanner(System.in);
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port =5001;
		int menu;
		try {
			Socket socket;
			socket = new Socket(ip,port);
			System.out.println("[프로그램을 시작합니다]");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		}catch (Exception e) {
			System.out.println("[서버와 연결에 실패했습니다.]");
			System.out.println("[프로그램을 종료합니다.]");
			return;
		}
		do {
			printMenu();
			menu=sc.nextInt();
			runMenu(menu);
		}while(menu != 5);
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 0:
			System.out.println("종료합니다.");
			break;
		default:
		}
	}
	private static void insert() {
		System.out.println("추가할 학생 정보를 입력하세요.");
		Student std = input();
		try {
			oos.writeInt(1);//메뉴전송
			oos.writeObject(std);
			oos.flush(); 
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("학생을 등록했습니다");
				return;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("학생을 등록하지 못했습니다.");
	}
	private static Student input() {
		Student std = inputBase();
		System.out.print("이름");
		String name = sc.nextLine();
		std.setName(name);
		return std;
	}
	private static Student inputBase() {
		System.out.print("학년: ");
		int grade = sc.nextInt();
		System.out.print("학급: ");
		int classNum = sc.nextInt();
		System.out.print("번호: ");
		int num = sc.nextInt();
		sc.nextLine();
		return new Student(grade,classNum,num,"");
	}
	private static void update() {
		try {
			System.out.print("학생 기본 정보 입력: ");
			Student std = inputBase();
			System.out.print("수정할 학생 정보 입력: ");
			Student upStd = input();
			oos.writeInt(2);
			
			oos.writeObject(std);
			oos.writeObject(upStd);
			oos.flush();
			
			boolean res = ois.readBoolean();
			if(res) 
				System.out.println("학생을 수정했습니다");
			else
				System.out.println("학생을 수정하지 못했습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void delete() {
		try {
			Student std = inputBase();
			oos.writeInt(3);
			oos.writeObject(std);
			oos.flush();
			boolean res = ois.readBoolean();
			if(res)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void search() {
		// TODO Auto-generated method stub
		
	}
	private static void printMenu() {
		System.out.print("1.학생 추가\n 2.학생 수정\n 3.학생 삭제\n 4.학생 조회\n0.종료 선택: ");
	}

}
