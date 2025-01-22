package day15.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex04_Server {

	public static void main(String[] args) {
		
		int port = 5001;
		
		try{
			//서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(port);
			List<ObjectOutputStream> list = new ArrayList<>();
			System.out.println("[연결 대기 중...]");
			
			//연결 대기, 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			System.out.println("[연결 성공!]");
			
			Server server = new Server(list,socket);
			server.receive();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
