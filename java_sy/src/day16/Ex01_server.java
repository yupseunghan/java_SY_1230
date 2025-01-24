package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
		String fileName="src/day16/data.txt";
		String fileName2="src/day16/count.txt";
		try {
		
			list=(List<Post>) load(fileName);
			int count2 =(Integer)load(fileName2);
			if(list==null)
				list = new ArrayList<Post>();
			else if(!list.isEmpty()){
				Post.setCount(count2);
			}
			else if(!list.isEmpty()) {
				int count = list.get(list.size()-1).getNum();//가장 마지막글 게시글 번호를 가져옴
				Post.setCount(count2);
			}
			ServerSocket serverSocket = new ServerSocket(port);
			
			//서버가 대기하다 연결 요청이 오면 Socket 객체를 생성
			//1. 서버 대기, 2. 연결 요청 수락, 3. Socket 객체 생성
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("[연결 완료]");
				try {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
					while(true) {
					//메뉴를 입력 받음
						int menu = ois.readInt();
					//입력받은 메뉴에 맞는 기능을 실행
						runMenu(menu, oos, ois);
					
					}
				}catch (Exception e) {
					System.out.println("[연결 종료]");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			save(fileName,list);
			save(fileName2,Post.getCount());
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
		case 5:
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
				 Post tmp = (Post)list.get(index).clone();
				 tmp.setTitle(post.getTitle());
				 tmp.setTitle(post.getContent());
				 list.set(index, tmp);
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
			List<Post> tmpList = new ArrayList<Post>();
			tmpList.addAll(list);
			oos.writeObject(tmpList);
			oos.flush();
			if(list==null||list.isEmpty())
				return;
			int num =ois.readInt();
			
			int index =list.indexOf(new Post(num));
			Post post = null;
			if(index >= 0) {
				post =list.get(index);
				post.view();
				post=(Post)post.clone();
				list.set(index, post);
			}
			oos.writeObject(post);
			oos.flush();
		}catch (Exception e) {
			System.out.println("조회 실패");
		}
	}
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
		}
		
	}
	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			return ois.readObject();
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("불러오기 실패");
			System.out.println("-----------------");
		}
		return null;
	}
}