package day16;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_server {
	static List<Post> list = new ArrayList<>();
	public static void main(String[] args) {
		
		int port = 5001;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			//서버가 대기하다 연결 요청이 오면 Socket 객체를 생성
			//1. 서버 대기, 2. 연결 요청 수락, 3. Socket 객체 생성
			Socket socket = serverSocket.accept();
			System.out.println("[연결 완료]");
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				//메뉴를 입력 받음
				int menu = ois.readInt();
				//입력받은 메뉴에 맞는 기능을 실행
				runMenu(menu, oos, ois);
				
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runMenu(int menu, ObjectOutputStream oos, ObjectInputStream ois) {
		switch(menu) {
		case 1:
			insert(oos, ois);
			break;
		case 2:
			update(oos, ois);
			break;
		case 3:
			delete(oos, ois);
			break;
		case 4:
			search(oos, ois);
			break;
		default:
			System.out.println("[잘못된 메뉴를 클라이언트가 전송했습니다.]");
		}
		
	}
	private static void insert(ObjectOutputStream oos, ObjectInputStream ois) {
		
		try {
			//게시글 정보를 받음
			Post post = new Post((Post)ois.readObject());
			
			//게시글 등록 > 결과를 보냄
			oos.writeBoolean(list.add(post));
			oos.flush();
		}catch (Exception e) {
			System.out.println("게시글 등록 실패");
		}
	}

	private static void update(ObjectOutputStream oos, ObjectInputStream ois) {
		 try {
			 //수정 정보 받음
			 Post post = new Post((Post)ois.readObject());
			 //수정하기
			 boolean res = true;
			 int index = list.indexOf(post);
			 if(index < 0)
				 res=false;
			 else {
				 list.get(index).setTitle(post.getTitle());
				 list.get(index).setTitle(post.getContent());
			 }
			 oos.writeBoolean(res);
			 oos.flush();
		 }catch (Exception e) {
			System.out.println("게시글 수정 실패");
		}
	}

	private static void delete(ObjectOutputStream oos, ObjectInputStream ois) {
		
		try {
			// 클라이언트가 보내준 게시글 번호 받기
			int num = ois.readInt();
			//받은 번호 객체 생성 및 제거 후 전송
			oos.writeBoolean(list.remove(new Post(num)));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void search(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			oos.writeObject(list);
			oos.flush();
			
			int num =ois.readInt();
			
			int index =list.indexOf(new Post(num));
			Post post = null;
			if(index >= 0) {
				post =list.get(index);
			}
			oos.writeObject(post);
			oos.flush();
		}catch (Exception e) {
			System.out.println("조회 실패");
		}
	}

}