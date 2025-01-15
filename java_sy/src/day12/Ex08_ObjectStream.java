package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex08_ObjectStream {

	public static void main(String[] args) {
		/*ObjectStream은 보조 스트림
		 * => 기반 스트림이 필요*/
		String fileName ="src/day12/object_stream.txt";
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			Point p =new Point(1,1);
			oos.writeObject(p);
					
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			try {
				Point p = (Point)ois.readObject();
				System.out.println(p);
				
			} catch (ClassNotFoundException e) {
				System.out.println("클래스를 찾을 수 없습니다");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
@Data
@AllArgsConstructor
class Point implements Serializable{
	/**
	 * serialVersionUID 클래스 상수로
	 * 저장된 값을 읽어올 때 사용
	 * 클래스 이름이 같더라도 serialVersionUID 값이 다르면 파일에서 읽어오ㅏ서
	 * 객체에 저장하지 못함
	 */
	private static final long serialVersionUID = 7450818179758423037L;
	private int x,y;
	@Override
	public String toString(){
		return"("+x+","+y+")";
	}

}