package Homework2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram implements ConsoleProgram {

	private Scanner sc = new Scanner(System.in);
	
	private StudentManager studentManager;
	private SubjectManager subjectManager;
	
	public void run() {
		

		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 0;
		
		//불러오기
		String studentFileName = "src/homework2/student.txt";
		String subjectFileName = "src/homework2/subject.txt";
		
		List<Student>students = (ArrayList<Student>)load(studentFileName);
		List<Subject>subjects = (List<Subject>) load(subjectFileName);
		
		studentManager = new StudentManager(students);
		subjectManager = new SubjectManager(subjects);
		
		do {
			//메뉴 출력
			printMenu();
			
			try {
				//메뉴 선택
				menu = sc.nextInt();
				
				//앞에서 입력한 엔터를 처리
				removeBuffer();
				
				//메뉴 실행
				runMenu(menu);
			}
			//잘못된 타입의 메뉴를 입력한 경우
			catch(InputMismatchException e) {
				System.out.println("올바른 입력이 아닙니다!");
				removeBuffer();
			}
			
		}while(menu != EXIT);
		
		save(studentFileName,studentManager.getList());
		save(subjectFileName,subjectManager.getList());
		
	}
	
	private void removeBuffer() {
		sc.nextLine();
	}
	
	@Override
	public void printMenu() {
		System.out.println("=========================================================");
		System.out.println("1. 학생 등록      4. 과목 등록       7.성적 등록     10.학생 조회");
		System.out.println("2. 학생 수정      5. 과목 수정       8.성적 수정     11.과목 조회");
		System.out.println("3. 학생 삭제      6. 과목 삭제       9.성적 삭제     12.성적 조회");
		System.out.println("0.종료");
		System.out.println("=========================================================");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 0:
			System.out.println("프로그램 종료");
			break;
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			insertSubject();
			break;
		case 5:
			updateSubject();
			break;
		case 6:
			deleteSubject();
			break;
		case 7:
			insertScore();
			break;
		case 8:
			updateScore();
			break;
		case 9:
			deleteScore();
			break;
		case 10:
			searchStudent();
			break;
		case 11:
			searchSubject();
			break;
		case 12:
			searchScore();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
	}
	
	private void searchScore() {
		System.out.println("-----------------");
		System.out.println("조회하려는 학생 정보를 입력하세요.");
		System.out.println("-----------------");
		
		//학년, 반, 번호를 입력
		//입력한 정보를 이용해서 객체를 생성
		Student std = setBaseStudent();
		
		if(studentManager.getStudent(std) == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("-----------------");
		System.out.println("조회하려는 과목 정보를 입력하세요.");
		System.out.println("-----------------");

		//학년, 학기, 과목명을 입력
		//과목정보로 객체를 생성
		Subject subject = setSubject();
		

		studentManager.printScore(std, subject);
	}
	private void searchSubject() {
		subjectManager.print();
	}
	private void searchStudent() {
		Student std = setBaseStudent();
		studentManager.printStudent(std);
	}
	private void deleteScore() {
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("-----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student std = setBaseStudent();
		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("-----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("-----------------");
		Subject subject = setSubject();
				
		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		if(studentManager.deleteScore(std, subject)) {
			System.out.println("성적을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 성적이 없습니다.");
	}
	private void updateScore() {

		System.out.println("-----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student std = setBaseStudent();

		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("-----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("-----------------");

		Subject subject = setSubject();

		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
				
		System.out.println("-----------------");
		System.out.println("새 성적 정보를 입력하세요.");
		System.out.println("-----------------");

		Subject newSubject = setSubject();

		if(!subjectManager.contains(newSubject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		System.out.print("성적 : ");
		int score = sc.nextInt();
		//새 과목 정보와 성적을 이용하여 성적 객체를 생성
		SubjectScore subjectScore = new SubjectScore(newSubject, score);
		//학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림
		if(studentManager.updateScore(std, subject, subjectScore)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		//실패하면 알림
		System.out.println("이미 등록된 성적입니다.");
	}
	private void insertScore() {
	
		Student setStd = setBaseStudent();
		if(studentManager.getStudent(setStd)==null) {
			System.out.println("일치하는 학생이 없습니다");
			return;
		}

		Subject setSub = setSubject();
		if(!subjectManager.contains(setSub)) {
			System.out.println("일치하는 과목이 없습니다");
			return;
		}
		
		System.out.print("성적: ");
		int score =sc.nextInt();

		SubjectScore subjectScore = new SubjectScore(setSub, score);
		
		 if(studentManager.insertScore(setStd,subjectScore)) {
			 System.out.println("성적을 추가했습니다.");
			 return;
		 }
		 System.out.println("이미 등록된 성적입니다");
	}
	private void deleteSubject() {
		Subject subject = setSubject();
		if(subjectManager.delSubject(subject)) {
			System.out.println("삭제 완료");
			return;
		}
		System.out.println("일치하는 과목이 없습니다");
	}
	private void updateSubject() {
		Subject subject = setSubject();
		if(!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다");
			return;
		}
		System.out.println("새 과목 정보 입력하세요");
		Subject newSubject = setSubject();
		if(subjectManager.updateSubject(subject,newSubject)) {
			System.out.println("과목을 수정 했습니다");
			return;
		}
		System.out.println("이미 등록된 과목입니다");
	}
	private  void insertSubject() {
		Subject subject = setSubject();
		if(subjectManager.insertSubject(subject)) {
			System.out.println("과목을 추가 했습니다");
			return;
		}
		System.out.println("이미 등록된 과목입니다");
	}
	private void deleteStudent() {
		Student setStd = setBaseStudent();
		if(studentManager.delStudent(setStd)) {
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}

	private void updateStudent() {
		Student setStd = setBaseStudent();
		Student selStd = studentManager.getStudent(setStd);
		if(selStd == null) {
			System.out.println("해당 학생을 찾을 수 없습니다");
			return;
		}
		Student newStd = setStudent();
		if(studentManager.updateStudent(selStd,newStd)) {
			System.out.println("학생을 수정했습니다");
			return;
		}
		System.out.println("이미 등록된 학생입니다");
	}
	private void insertStudent() {
		Student setStd = setStudent();
		if(studentManager.insertStudent(setStd)) {
			System.out.println("추가 완료");
		}
		System.out.println("이미 등록된 학생");
		return;
	}
	private  Subject setSubject() {
		System.out.print("과목 정보 입력\n학년 : ");
		int grade = sc.nextInt();
		System.out.print("학기 : ");
		int semester = sc.nextInt();
		System.out.print("과목 : ");
		removeBuffer();
		String name = sc.nextLine();
		return new Subject(grade,semester,name);
	}
	private  Student setBaseStudent() {
		System.out.print("학생 정보 입력\n학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int classNum = sc.nextInt();
		System.out.print("번호: ");
		int num = sc.nextInt();
		//입력받은 정보로 객체 생성
		return new Student(grade,classNum,num,"");
	}
	private Student setStudent() {
		Student tmp = setBaseStudent();
		removeBuffer();
		System.out.print("이름: ");
		String name = sc.nextLine();
		tmp.setName(name);
		return tmp;
	}
}
