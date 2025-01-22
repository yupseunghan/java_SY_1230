package day15.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
	private List<Student> list;
	private Socket socket;
	public void run() {
		Thread t= new Thread(()->{
			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				int menu= ois.readInt();
				runMenu(menu,ois,oos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		t.start();
	}
	private synchronized void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
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
			
		}
	}
	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			Student std = (Student)ois.readObject();
			boolean res = true;
			
			if(list.contains(std)) {
				res=false;
			}else {
				list.add(std);
			}
			oos.writeBoolean(res);
			System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void update(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//학생 기본 정보를 클라이언트에게 받음
			Student std = (Student)ois.readObject();
			//수정할 학생 정보도 받음
			Student upStd = (Student)ois.readObject();
			//학생이 없으면 flase를 저장
			boolean res = true;
			//다른 학생으로 수정하려는데 이미 등록됐으면
			//학생과 수정할 학생이 다르고 수정할 학생이 있므녀 flase를 저장
			if(!list.contains(std)) {
				res=false;
			}else if(!std.equals(upStd) && list.contains(upStd)) {
				res = false;
			}//기존 학생 정보를 가져와서 수정
			else {
				list.remove(std);
				list.add(upStd);
				sort();
			}
			oos.writeBoolean(res);
			oos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void sort() {
		list.sort((o1,o2)->{
			if(o1.getGrade() != o2.getGrade()) {
				return o1.getGrade()-o2.getGrade();
			}
			if(o1.getClassNum() != o2.getClassNum()) {
				return o1.getClassNum() - o2.getClassNum();
			}
			return o1.getNum()-o2.getNum();
		});
		System.out.println(list);
	}
	private void delete(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			Student std = (Student)ois.readObject();
			boolean res= true;
			if(!list.contains(std))
				res=false;
			else {
				list.remove(std);
			}
			oos.writeBoolean(res);
			oos.flush();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void search(ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
		
	}
	public void send() {
		
	}
}
