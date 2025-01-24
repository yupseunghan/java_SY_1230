package day17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_Server2 {
	static List<Record> list = new ArrayList<>();
	public static void main(String[] args) {
		int port =5002;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				
				while(true) {
					Socket socket = serverSocket.accept();
					Server server = new Server(socket,list);
					server.run();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
