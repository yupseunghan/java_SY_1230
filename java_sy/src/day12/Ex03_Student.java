package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {
	static Scanner sc= new Scanner(System.in);
	static List<Student> list = new ArrayList<>();
	public static void main(String[] args) {
		/*
		 * 다음 기능을 갖는프로그램을 작성
		 * 1.학생 추가
		 * 	-학년,반,번호,이름 입력
		 * 2.학생 조회
		 * 3.종료
		 * 
		 * 2-1 학년 조회: 학년
		 * 2-2 반 조회:학년,반
		 * 2-3 번호 조회:학년,반,번호
		 * 2-4 전체 조회:X*/
		list.add(new Student(1,1,1,"홍길동"));
		list.add(new Student(1,1,2,"임꺽정"));
		list.add(new Student(2,1,1,"둘리"));
		list.add(new Student(3,1,1,"고길동"));
		list.add(new Student(3,2,1,"또치"));
		runMenu();
	}
	private static void runMenu() {
		char menu;
		do {
			System.out.println("1.학생 추가\n2.학생 조회\n3.삭제\n4.종료");
			menu=sc.next().charAt(0);
			switch(menu) {
			case'1': insertStudent(list); break;
			case'2': menu2(); break;
			case'3': delStudent(list);break;
			case'4': System.out.println("프로그램 종료"); return;
			}
		}while(menu!='4');
	}
	private static void delStudent(List<Student> list) {
		System.out.println("삭제할 이름 입력: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		List<Student> tmpList = 
				list.stream().filter(s->s.getName().contains(name))
				.collect(Collectors.toList());
		print(tmpList,s->true,true);
		
		System.out.println("삭제할 번호 입력: ");
		int num = sc.nextInt();
		
		Student tmp = tmpList.get(num-1);
		list.remove(tmp);

	}
	private static void menu2() {
		Stream<Student> stream = list.stream();
		char menu;
		System.out.println("조회를 시작합니다\n1.학년 조회\n2.반 조회\n3.번호 조회\n4.전체 조회");
		menu=sc.next().charAt(0);
		switch(menu) {
		case'1': checkGrade(); return;
		case'2': checkClass(); return;
		case'3': checkNum(); return;
		case'4': checkStudent(); return;
		}
	}
	private static void checkStudent() {
		print(list,s->true);
	}
	private static void checkNum() {
		System.out.print("학년: ");
		int grade =sc.nextInt();
		System.out.print("반: ");
		int clas =sc.nextInt();
		System.out.print("번호: ");
		int num =sc.nextInt();
		print(list,s->s.getGrade()==grade && s.getClas()==clas&&s.getNum()==num);
	}
	private static void checkClass() {
		System.out.print("학년: ");
		int grade =sc.nextInt();
		System.out.print("반: ");
		int clas =sc.nextInt();
		print(list,s->s.getGrade()==grade && s.getClas()==clas);
	}
	private static void checkGrade() {
		System.out.print("학년: ");
		int grade =sc.nextInt();
		print(list,s->s.getGrade()==grade);
	}
	//이거야
	private static void print(List<Student>list,Predicate<Student> p) {
		print(list,p,false);
	}
	private static void print(List<Student>list,Predicate<Student> p,boolean isCount) {
		Stream<Student> stream = list.stream();
		AtomicInteger index = new AtomicInteger(1);
		stream
		.filter(p)
		.forEach(s->{
			int curIndex = index.getAndIncrement();
			System.out.println((isCount?curIndex+". ":"")+s.toString());
		});
	}
	private static void insertStudent(List<Student> list) {
		System.out.println("학생 추가");
		System.out.print("학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int clas = sc.nextInt();
		System.out.print("번호: ");
		int num = sc.nextInt();
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		list.add(new Student(grade,clas,num,name));
		System.out.println("추가 완료");
	}
}
@Data
@AllArgsConstructor
class Student{
	private int grade,clas,num;
	private String name;
	@Override	
	public String toString() {
		return grade+"학년 "+clas+"반 "+num+"번 "+name;
	}
}