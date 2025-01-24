package day17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_Server {
	static List<Record> list = new ArrayList<>();
	public static void main(String[] args) {
		int port =5002;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				
				while(true) {
					Socket socket = serverSocket.accept();
					Thread t =new Thread(()->{						
						try {
							ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
							ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
							System.out.println("[연결 완료]");
							while(true) {
								//메뉴를 입력받음
								int menu=ois.readInt();
								//메뉴에 따라 기능을 실행
								runMenu(menu,ois,oos);
							}
						}catch (Exception e) {
							System.out.println("[연결 해제]");
						}
					});
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			insertRecord(ois,oos);
			break;
		case 2:
			recordView(ois,oos);
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void insertRecord(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//기록을 수신
			Record r = (Record) ois.readObject();
			//기록 추가
			boolean res =list.add(r);
			Collections.sort(list,(o1,o2)->{
				Record r1 = (Record) o1;
				Record r2 = (Record) o2;
				if(r1.getCount()!=-r2.getCount()) {
					return r1.getCount()-r2.getCount();
				}
				if(!r1.getDate().equals(r2.getDate())) {
					return r1.getDate().compareTo(r2.getDate());
				}
				return r1.getNickName().compareTo(r2.getNickName());
			});
			oos.writeBoolean(res);
			oos.flush();
			System.out.println(list);
		}catch (Exception e) {
			System.out.println("[기록 추가시 예외 발생]");
		}
	}

	private static void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//복사본 넘기기
			List<Record> tmp = list.subList(0,Math.min(5, list.size()));
			List<Record> sendList = new ArrayList<Record>();
			sendList.addAll(tmp);
			oos.writeObject(sendList);
			oos.flush();
		} catch (Exception e) {
			System.out.println("[기록 조회시 예외 발생]");
		}
	}

}
