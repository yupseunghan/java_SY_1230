package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		/*다음 기능을 갖는 프로그램을 작성
		 * 단, 저장기능과 불러오기 기능을 추가
		 * - 저장은 프로그램 종료하기 전
		 * -불러오기는 프로그램 시작 전
		 * 1.자동차 추가
		 * 2.자동차 조회(전체)
		 * 3.종료
		 * ArrayList 클래스도 Serializable 인터페이스를 구현한 구현 클래스이다.*/
		String fileName = "src/day12/car_stream";
		ArrayList<Car> list = new ArrayList<>();
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		char menu;
		do {
			System.out.println("1.자동차 추가\n2.자동차 조회\n3.종료\n선택: ");
			menu=sc.next().charAt(0);
		}while(menu !='3');
	}
}
@Data
@AllArgsConstructor
class Car{
	private String name,brand;
}