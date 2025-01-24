package day17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class Client {
	private static Scanner sc = new Scanner(System.in);	
	public static void main(String[] args) {
		String ip="192.168.40.3";
		int port=5002;
		Socket socket;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		try {
			socket = new Socket(ip,port);
			System.out.println("[프로그램 시작]");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			System.out.println("연결 실패");
			System.out.println("[프로그램 종료]");
			return;
		}
		int menu;
		do {
			printMenu();
			menu=sc.nextInt();
			runMenu(menu,ois,oos);
		}while(menu !=3);
	}
	private static void printMenu() {
		System.out.println("========Base Ball=========");
		System.out.println("======1.Play Ball=========");
		System.out.println("====2.Player Record=======");
		System.out.println("=========3.EXIT===========");
		System.out.print("입력 :");
	}
	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			play(ois,oos);
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
	private static void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			oos.writeInt(2);
			oos.flush();
			//전송받은 기록 리스트를 받아옴
			List<Record> list;
			try {
				list = (List<Record>) ois.readObject();
				//받아온 기록 리스트를 출력
				printRecord(list);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void printRecord(List<Record> list) {
		if(list==null||list.isEmpty()) {
			System.out.println("등록된 기록이 없습니다");
			System.out.println("지금 플레이하면 1등");
			return;
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(i+1+". "+list.get(i).toString());
		}
	}
	private static void play(ObjectInputStream ois, ObjectOutputStream oos) {
		//랜덤 리스트 생성
		List<Integer> nums = randomList(1,9,3);
		Record r = playGame(nums);
		//서버 전송 메서드
		sendRecord(r,ois,oos);
	}
	private static void sendRecord(Record r, ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//메뉴를 전송
			oos.writeInt(1);
			//기록을 전송
			oos.writeObject(r);
			//서버에게 결과 확인받고 종료
			oos.flush();
			boolean res=ois.readBoolean();
			if(!res)
				System.out.println("결과 기록 실패");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static List<Integer> randomList(int min, int max, int size) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		while(set.size()<size) {
			set.add(random(min,max));
		}
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		return list;
	}
	private static Record playGame(List<Integer> nums) {
		int st,b;
		int count =0;
		List<Integer> user = new ArrayList<>();
		do {
			user.clear();
			System.out.println("입력: ");
			//사용자가 중복되지 않게 입력했다고 가정
			while(user.size()<3) {
				user.add(sc.nextInt());
			}
			++count;
			st = getSt(nums,user);
			b= getB(nums,user);
			printRes(st,b);
		}while(st<3);
		System.out.print("이니셜 입력(최대 3자): ");
		String nickName = sc.next();
		
		return new Record(count, nickName);
	}
	private static void printRes(int st, int b) {
		if(st!=0) {
			System.out.print(st+"S ");
		}
		if(b!=0)
			System.out.print(b+"B");
		if(st==0 && b==0)
			System.out.println("3O");
		
	}
	private static int getB(List<Integer> nums, List<Integer> user) {
		int count=0;
		for(int num: nums) {
			if(user.contains(num)) {
				count++;
			}
		}
		return count-getSt(nums,user);
	}
	private static int getSt(List<Integer> nums, List<Integer> user) {
		int count=0;
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)==user.get(i))
				count++;
		}
		return count;
	}
	private static int random(int min, int max) {
		if(max<min) {
			int tmp=min;
			min=max;
			max=tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
}
