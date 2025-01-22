package Homwork.ex2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class StudentMain {
	/* 학생 성적 관리 프로그램을 작성하세요.
	 * 1. 학생 등록
	 * 	- 학년, 반, 번호, 이름을 입력받아 등록
	 * 	- 이미 등록된 학생 정보(학년, 반, 번호가 같은 경우)라면 등록하지 않음
	 * 2. 학생 수정
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고, 있으면 수정
	 * 	- 수정하는 정보는 학년, 반, 번호, 이름을 수정
	 * 	- 이미 등록된 학생 정보로 수정하려고 하면 수정하지 않음
	 * 3. 학생 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고 있으면 삭제
	 * 4. 과목 등록
	 * 	- 학년, 학기, 과목명을 입력받아 없으면 등록
	 * 5. 과목 수정
	 * 	- 학년, 학기, 과목을 입력받아 있으면 학년, 학기, 과목을 입력받아 수정
	 * 	- 수정하려는 과목이 이미 등록된 과목이라면 수정하지 않음
	 * 6. 과목 삭제
	 * 	- 학년, 학기, 과목을 입력받아 있으면 삭제
	 * 7. 성적 등록
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 과목을 출력
	 * 	- 과목을 선택
	 * 	- 성적을 입력해서 학생 성적을 등록
	 * 8. 성적 수정
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 학년, 학기, 과목명을 입력받고 있으면 성적을 입력받아 수정
	 * 9. 성적 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 학년, 학기, 과목명을 입력받고 있으면 삭제
	 * 10. 학생 조회
	 * 	- 학년, 반을 입력하면 학생들을 조회
	 * 11. 과목 조회
	 * 	- 등록된 과목 전체를 조회
	 * 12. 성적 조회
	 * 	- 학년, 반, 번호를 입력하면 학생 있으면 학생 성적을 조회
	 * */
	//등록된 과목을 관리할 과목 리스트
	static ArrayList<Subject> subjectList = new ArrayList<Subject>();
	//등록된 학생을 관리할 학생 리스트
	static ArrayList<Student> studentList = new ArrayList<Student>();
	//입력을 위한 Scanner
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 0;
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

	}
	//입력 버퍼에 남아 있는 문자열(엔터)을 제거하는 메소드
	private static void removeBuffer() {
		sc.nextLine();
	}

	private static void printMenu() {
		System.out.println("=========================================================");
		System.out.println("1. 학생 등록      4. 과목 등록       7.성적 등록     10.학생 조회");
		System.out.println("2. 학생 수정      5. 과목 수정       8.성적 수정     11.과목 조회");
		System.out.println("3. 학생 삭제      6. 과목 삭제       9.성적 삭제     12.성적 조회");
		System.out.println("0.종료");
		System.out.println("=========================================================");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void runMenu(int menu) {

		switch(menu) {
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
		case 0:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
		
	}

	private static void searchScore() {
		//학년, 반, 번호를 입력
		//입력한 정보를 이용해서 객체 생성
		Student setStd = setBaseStudent();
		//리스트에 학생이 없으면 알림 후 종료
		int index = studentList.indexOf(setStd);
		if(index<0) {
			System.out.println("해당 학생이 없습니다");
			return;
		}
		//학년, 학기, 과목명을 입력
		//과목 정보로 객체를 새성
		Subject setSub = setSubject();
		//리스트에서 학생을 선택
		//선택한 학생에게 과목정보를 주면서 정적을 출력하고 요청
		studentList.get(index).printScore(setSub);
	}
	private static void searchSubject() {
		if(!subjectList.isEmpty()) {
			for(Subject sb:subjectList) 
				sb.print();
		}else
			System.out.println("과목이 없습니다");
		
	}
	private static void searchStudent() {
		//학년, 반, 번호를 입력
		// 입력한 정보를 이용해서 객체 생성
		Student std = setBaseStudent();
		//리스트에서 일치하는 학생이 있으면 정보 출력
		int index = studentList.indexOf(std);
		if(index==-1) {
			// 없으면 없다고 추력
			System.out.println("학생을 찾을 수 없습니다");
		}else {
			studentList.get(index).print();
		}	
	}
	private static void deleteScore() {
		//학년, 반, 번호를 입력
		//입력한 정보를 객체로 생성 (Student)
		Student setStd = setBaseStudent();
		//리스트에 이쓴ㄴ지 확인해서 없으면 알림후 종료
		int index = studentList.indexOf(setStd);
		if(index<0) {
			System.out.println("해당 학생이 없습니다");
			return;
		}
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성
		Subject setSub = setSubject();
		//과목 리스트에 등록된 환인 후 아니면 알ㄹ미 후 종료
		if(!subjectList.contains(setSub)){
			System.out.println("해당 과목이 없습니다");
			return;
		}
		// 학생에게 과목 정보를 주면서 성적을 삭제하라고 요청 후 성공 알림
		if(studentList.get(index).delScore(setSub)) {
			System.out.println("성적을 삭제 했습니다");
			return;
		}else
			System.out.println("성적 삭제 실패");
		// 실패하면 실패알림
		 
	}
	private static void updateScore() {
		//학년, 반, 번호를 입력
		//입력한 정보를 객체로 생성 (Student)
		Student setStd = setBaseStudent();
		//리스트에 이쓴ㄴ지 확인해서 없으면 알림후 종료
		int index = studentList.indexOf(setStd);
		if(index<0) {
			System.out.println("해당 학생이 없습니다");
			return;
		}
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성
		Subject setSub = setSubject();
		//과목 리스트에 등록된 환인 후 아니면 알ㄹ미 후 종료
		if(!subjectList.contains(setSub)){
			System.out.println("해당 과목이 없습니다");
			return;
		}
		// 새 과목 정보를 입력(학년, 학기)을 입력
		// 과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		Subject newSubject = setSubject();
		if(!subjectList.contains(newSubject)){
			System.out.println("해당 과목이 없습니다");
			return;
		}
		// 성적을 입력
		System.out.print("성적: ");
		int score = sc.nextInt();
		// 새 과목 정보와 성적을 이용하여 성적 객체를 생성
		SubjectScore newsbs = new SubjectScore(newSubject, score);
		// 학생에게 기존 과몯 정보와 성적 객체를 생성
		if(studentList.get(index).updateScore(setSub,newsbs)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 성적입니다");
		// 학생에게
		 
	}
	private static void insertScore() {
		//학년, 반, 번호를 입력
		//입력한 정보를 객체로 생성 (Student)
		Student setStd = setBaseStudent();
		//리스트에 이쓴ㄴ지 확인해서 없으면 알림후 종료
		int index = studentList.indexOf(setStd);
		if(index<0) {
			System.out.println("해당 학생이 없습니다");
			return;
		}
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성
		Subject setSub = setSubject();
		//과목 리스트에 등록된 환인 후 아니면 알ㄹ미 후 종료
		if(!subjectList.contains(setSub)){
			System.out.println("해당 과목이 없습니다");
			return;
		}
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성
		System.out.print("성적: ");
		int score =sc.nextInt();
		//학생을 선택하여 객체 저장
		SubjectScore subjectScore = new SubjectScore(setSub, score);
		/*{학생 성적에 새 성적이 있는지 확인해서 없으면 추가 후 알림
	  	  있으면 추가 안하고 알림
		  학생에게 새 성적을 주고 추가 하라고 시킨 후 추가 여부를 이용하여 추가했으면 성공 알림
		  실패했으면 실패 알림}
		*/
		 if(studentList.get(index).insertScore(subjectScore)) {
			 System.out.println("성적을 추가했습니다.");
			 return;
		 }
		 System.out.println("이미 등록된 성적입니다");
	}
	private static void deleteSubject() {
		//학년, 학기, 과목명 입력
		//입력한 정보 객체 생성
		Subject setSub = setSubject();
		//리스트에서 생성한 객체 제거 성공하면 성공

		if(subjectList.remove(setSub)) {

		int index = subjectList.indexOf(setSub);
		if(index != -1) {
			subjectList.remove(index);

			System.out.println("제거 완료");
			return;
			}
		}//실패하면 실패
		System.out.println("삭제 할 과목이 없습니다");
	}
	private static void updateSubject() {
		/* 
		 * 1 1 국어
		 * 1 2 국어
		 * 2 1 영어
		 * 2 2 영어
		 * 1 3 국어 
		 * 
		 * 1 3 국어 => 1 1 국어 x
		 * 1 3 국어 => 1 3 국어 O
		 * 1 3 국어 => 1 1 수학 O*/
		//학년, 학기, 과목명을 입력
		Subject setSub = setSubject();
		//등록된 과목이 아니면 알림 후 종료 => indexOf로 번지를 가져와서 사용
		int index = subjectList.indexOf(setSub);
		if(index == -1) {
			System.out.println("등록된 과목이 아닙니다");
			return;
		}
		//새 과목 정보를 입력(학년, 학기, 과목)
		Subject updateSubject = setSubject();
		//등록된 과목이면 알림 후 종료
		int updateIndex = subjectList.indexOf(updateSubject);
		if(updateIndex != -1) {
			System.out.println("그 과목은 이미 등록되었습니다");
			return;
		}//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장
		else {
			subjectList.set(index, updateSubject);
			System.out.println("수정 완료");
		}
		
		//아니면 수정
	}
	private static void insertSubject() {
		//학년, 학기, 과목명을 입력
		Subject setSub = setSubject();
		if(subjectList.indexOf(setSub) != -1) {
			//이미 등록된 과목이면 알림 후 종료 => Subject클래스의 equals를 오버라이딩
			System.out.println("이미 등록된 과목");
			return;
		}
		subjectList.add(setSub);
		System.out.println("과목 추가");
	}	
	private static void deleteStudent() {
		//학년, 반, 번호를 입력
		//입력받은 정보로 객체 생성
		Student setStd = setBaseStudent();
		//생성한 객체를 이용하여 리스트에서 삭제
		if(studentList.remove(setStd)) {
			//삭제에 성공하면 성공알림문구
			System.out.println("삭제 성공");
		}
		else {
		//실패하면 실패 알림문구 출력
		System.out.println("삭제 실패");
		}
	}

	private static void updateStudent() {
		//학년, 반, 번호 입력
		//입력한 학생 정보를 객체 생성
		Student setStd = setBaseStudent();
		//생성한 객체가 리스트에 있으면 번지를 가져옴
		int index = studentList.indexOf(setStd);
		//번지가 음수이면(없으면) 안내문구 출력 후 종료
		if(index == -1) {
			System.out.println("해당 학생을 찾을 수 없습니다");
			return;
		}
		//아니면(학생이 있으면) 수정할 학년, 반, 번호, 이름을 입력
		//입력받은 정보로 객체를 생성
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		Student updateStudent = setStudent();
		//수정 할 자리에 객체가 있으면 리턴
		int updateIndex = studentList.indexOf(updateStudent);
		if(updateIndex != -1) {
			System.out.println("그 학생은 이미 등록되었습니다");
			return;
		}
		else{
			Student old = studentList.set(index, updateStudent);
			updateStudent.setList(old.getList());
			System.out.println("수정 완료");
		}
	}

	private static void insertStudent() {
		//학년, 반, 번호, 이름 입력
		//주의: 학생 객체 생성시 성적 리스틍를 생성
		//입력 받은 학년, 반, 번호, 이름을 이용하여 객체 생성 => 리스트에 있는 기능을 활용하기 위해
		Student setStd = setStudent();
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료 => Student클래스의 equals를 오버라이딩
		//리스트.indexOf(객체2) => Objects.equals(객체1, 객체2) => 객체1.equals(객체2)
		if(studentList.contains(setStd)) {
			System.out.println("이미 등록된 학생");
			return;
		//없으면 리스트에 추가 후 안내 문구
		}
		studentList.add(setStd);
		System.out.println("추가 완료");
	}
	private static Subject setSubject() {
		System.out.print("과목 정보 입력\n학년 : ");
		int grade = sc.nextInt();
		System.out.print("학기 : ");
		int semester = sc.nextInt();
		System.out.print("과목 : ");
		removeBuffer();
		String name = sc.nextLine();
		return new Subject(grade,semester,name);
	}
	private static Student setBaseStudent() {
		System.out.print("학생 정보 입력\n학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int classNum = sc.nextInt();
		System.out.print("번호: ");
		int num = sc.nextInt();
		//입력받은 정보로 객체 생성
		return new Student(grade,classNum,num,"");
	}
	private static Student setStudent() {
		Student tmp = setBaseStudent();
		removeBuffer();
		System.out.print("이름: ");
		String name = sc.nextLine();
		tmp.setName(name);
		return tmp;
	}
}