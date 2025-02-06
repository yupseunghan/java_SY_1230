package day21;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client {
	private String id;
	private Socket socket;
	private List<Chat> list;
	
	private final String EXIT = "EXIT";
	
	public void receive() {
		Thread t = new Thread(()->{
			try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())){
				
				while(true) {
					//문자열 대신 Chat 객체를 받고,
					Chat chat = (Chat) ois.readObject();
					//채팅 내용이 EXIT와 갗으면 종료
					if(chat.getChat().equals(EXIT)) {
						break;
					}
					//받은 객체를 출력
					System.out.println(chat);
					//객체를 채팅 내역에 추가
					list.add(chat);
				}
			} catch (Exception e) {
				return;
			} 
			System.out.println("[상대방이 나갔습니다. 종료하려면 "+ EXIT +"를 입력하세요.]");
		});
		t.start();
	}
	
	public void send() {

		Scanner scan = new Scanner(System.in);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());) {
			
			System.out.println("[채팅을 시작합니다.]");
			System.out.println("[자유롭게 채팅 하시고 종료하려면 " + EXIT + "를 입력하세요.]");
			while(true) {
				if(socket == null || socket.isClosed()) {
					throw new SocketException();
				}
				String str = scan.nextLine();
				//문자열이 안닌 Chat의 객체를 전송
				Chat chat = new Chat(id, str);
				oos.writeObject(chat);
				oos.flush();
				if(str.equals(EXIT)) {
					break;
				}
				//채팅 기록에 추가
				list.add(chat);
			}
		}catch(Exception e) {
			//e.printStackTrace();
		}
		finally {
			System.out.println("[채팅을 종료합니다.]");
		}
	
	}
	
	public void run() {
		
		//send와 receive를 이용하여 호출
		//이 때 둘 중 하나는 쓰레드를 제거. 밑에 있는 메소드의 쓰레드를 제거하면 됨
		//제거하는 이유? 제거를 안하면 두 메소드가 쓰레드로 실행되게 때문에 run메소드가
		//종료되고, 그러면 메인 메뉴로 채팅이 끝나지 않은 상태에서 종료될 수 있기 때문에.
		receive();
		send();
	}
}