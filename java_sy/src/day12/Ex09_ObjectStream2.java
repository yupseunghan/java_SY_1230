package day12;

import java.awt.JobAttributes.SidesType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		String fileName = "src/day12/car.txt";
		List<Car> list = new ArrayList<>();
		
		load(fileName,list);
		
		int menu;
		final int EXIT =3;
		do {
			printMenu();
			menu = sc.nextInt();
			reunMenu(list,menu);
		}while(menu!=EXIT);
		save(fileName,list);
	}
	private static void reunMenu(List<Car> list,int menu) {
		switch(menu) {
		case 1 :insertCar(list);break;
		case 2 :printCar(list);break;
		case 3 :break;
		default: System.out.println("잘못 입력");
		}
	}
	private static void insertCar(List<Car> list) {
		System.out.println("브랜드 입력: ");
		sc.nextLine();
		String brand =sc.nextLine();
		
		System.out.println("이름 입력: ");
		String name =sc.nextLine();
		
		list.add(new Car(name,brand));
	}
	private static void printCar(List<Car> list) {
		list.sort((o1,o2)->{
			if(!o1.getBrand().equals(o2.getBrand())) {
				return o1.getBrand().compareTo(o2.getBrand());
			}
			return o1.getName().compareTo(o2.getName());
		});
		for(Car car:list) {
			System.out.println(car);
		}
	}
	private static void printMenu() {
		System.out.println("------------------\n"
				+ "1.자동차 추가\n"
				+ "2.자도앚 조회\n"
				+ "3.종료\n"
				+ "------------------\n"
				+ "메뉴선택");
	}
	private static void save(String fileName, List<Car> list) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					oos.writeObject(list);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("파일을 찾을 수 없습니다");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("IO 예외 발생");
				}
	}
	private static void load(String fileName, List<Car> list) {
		try(FileInputStream fos = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fos)) {
					List<Car> tmp = (List<Car>) ois.readObject();
					list.addAll(tmp);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("파일을 찾을 수 없습니다");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("IO 예외 발생");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("클래스를 찾을 수 없습니다");
				}
	}
	
}
@Data
@AllArgsConstructor
class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brand;
	private String name;
	
	public String toString() {
		return brand+" : "+name;
	}
}