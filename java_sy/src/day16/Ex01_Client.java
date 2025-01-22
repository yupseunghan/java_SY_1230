package day16;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

import day02.s;


public class Ex01_Client {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/* day14/Ex01_Post 예제를 활용하여 게시글 관리 프로그램을 작성하세요.
		 * 단, 네트워크 통신을 이용하여 서버와 클라이언트로 동작하는 프로그램을 작성하세요.
		 * */
		String ip = "127.0.0.1";
		int port = 5001;
		Socket socket = null;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("연결 성공");
			
		}catch (Exception e) {
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다.");
			return;
		}
		
		int menu = 0;
		do {
			printMenu();
			
			menu = sc.nextInt();
			sc.nextLine();
			try {
				oos.writeInt(menu);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("정수 입력해라");
			}
			runMenu(menu, ois,oos);
			
		}while(menu != 5);
	}
	
	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {

		switch(menu) {
		case 1:
			insert(ois,oos);
			break;
		case 2:
			update(ois,oos);
			break;
		case 3:
			delete(ois,oos);
			break;
		case 4:
			search(ois,oos);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			
		}
		
	}
	private static void insert(ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			Post post = input();
			
			//게시글 정보를 서버에 전송
			oos.writeObject(post);
			oos.flush();
			//서버에서 등록 결과를 받음
			
			boolean res = ois.readBoolean();
			//알림 출력
			if(res)
				System.out.println("게시글 등록");
			else
				System.out.println("게시글 등록x");
		} catch (IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		
	}

	private static void update(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			System.out.print("게시글 번호 입력: ");
			int num=sc.nextInt();
			sc.nextLine();
			System.out.println("수정 내용 입력하세요");
			Post newPost = input();
			//게시글 번호를 입력받은 번호로 수정
			newPost.setNum(num);
			// 수정할 내용 전송
			oos.writeObject(newPost);
			oos.flush();
			//결과받아서 알림
			boolean res = ois.readBoolean();
			if(res)
				System.out.println("게시글 수정 완료");
			else
				System.out.println("게시글 수정 실패");
			
		}catch (Exception e) {
			System.out.println("예외 발생");
		}
	}
	private static void search(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//서버 전체 게시글 요청
			List<Post> list = (List<Post>)ois.readObject();
			if(!print(list))
				return;
			//조회할 게시글 번호 입력
			System.out.print("조회할 번호: ");
			int num = sc.nextInt();
			sc.nextLine();
			//서버에게 게시글 번호 전송
			oos.writeInt(num);
			oos.flush();
			//서버에게 게시글 받아서 출력
			Post post = new Post((Post)ois.readObject());
			if(post==null)
				System.out.println("등록되지 않거나 삭제된 글입니다");
			else {
				post.print();
			}
		}catch (Exception e) {
			
		}
	}

	private static boolean print(List<Post> list) {
		boolean res =true;
		if(list == null || list.isEmpty())
			return !res;
		for(Post tmp:list) {
			System.out.println(tmp.toString());
		}
		return res;
	}

	private static void delete(ObjectInputStream ois, ObjectOutputStream oos) {
		//서버에 번호 전송
		try {
			System.out.print("삭제할 게시글 번호 입력: ");
			int num=sc.nextInt();
			sc.nextLine();
			oos.writeInt(num);
			oos.flush();
			//서버에서 보낸 결과 이용 알림
			boolean res = ois.readBoolean();
			if(res)
				System.out.println("게시글 삭제 완료");
			else
				System.out.println("게시글 삭제 실패");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private static Post inputBase() {
		System.out.print("제목: ");
		String title = sc.nextLine();
		System.out.print("내용: ");
		String content = sc.nextLine();
		return new Post (title,content,"");
	}
	private static Post input() {
		Post p =inputBase();
		System.out.print("작성자: ");
		String writer = sc.nextLine();
		p.setWriter(writer);
		return p;
	}
	private static void printMenu() {
		System.out.println("--------------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
	}
}