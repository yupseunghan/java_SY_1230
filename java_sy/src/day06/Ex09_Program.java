package day06;

/*
  메뉴
  1.학생 국어 성적 추가
  2.학생 국어 성적 전체 조회
  3.종료
  메뉴선택: 1
  이름: 홍길동
  성적: 100
  메뉴
  1.
  2.
  3.
  메뉴 선택 2
  이름:
  ~
  이름: 
  성적:
  평균:
 */
import java.util.Scanner;

public class Ex09_Program {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Student[] std = new Student[5];
		char menu;
		int count=0;
		do {
			input();
			menu=sc.next().charAt(0);
			count = runMenu(menu,std,count);
			std = expend(std,count);
		}while(menu != '3');
	} 
	
	private static Student[] expend(Student[] std, int count) {
		if(std==null)
			return new Student[5];
		if(count < std.length)
			return std;
		Student tmp[] = new Student[std.length+5];
		System.arraycopy(std, 0, tmp, 0, std.length);
		return tmp;
	}
	
	private static int runMenu(char menu,Student[] std,int count) {
		switch(menu) {
		case '1':
			count=insertStudent(std,count);
			break;
		case '2':
			printStudent(std,count);
			break;
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 압니다.");
		}
		return count;
	}
	
	private static int insertStudent(Student[] std, int count) {
		//학생 정보를 입력
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("성적: ");
		int score = sc.nextInt();
		//학생 정보를 이용해서 객체 생성
		Student s = new Student(name,score);
		//배열에 추가
		std[count]=s;
		return count+1;
	}
	
	private static void printStudent(Student[] std, int count) {
		double res=0;
		for(int i=0; i <count; i++) {
			System.out.println(std[i].name+": "+std[i].score);
			res+=std[i].score;
		}
		System.out.println("평균"+res/count);
	}
	
	public static void input() {
		System.out.println("메뉴");
		System.out.println("1. 학생 국어 성적 추가");
		System.out.println("2. 학생 국어 성적 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴선택: ");
	}
}

class Student{
	String name;
	int score;
	public Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}