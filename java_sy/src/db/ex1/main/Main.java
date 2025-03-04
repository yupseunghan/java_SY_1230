package db.ex1.main;

import java.util.List;

import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.StudentVO;
import db.ex1.model.vo.SubjectVO;
import db.ex1.service.ScoreService;
import db.ex1.service.ScoreServiceImp;
import db.ex1.service.StudentService;
import db.ex1.service.StudentServiceImp;
import db.ex1.service.SubjectService;
import db.ex1.service.SubjectServiceImp;

public class Main {
	static StudentService studentService = new StudentServiceImp();
	static SubjectService subjectService = new SubjectServiceImp();
	static ScoreService scoreService = new ScoreServiceImp();
	public static void main(String[] args) {
		//등록된 모든 학생을 가져와서 콘솔차엥 확인하는 코드
		List<StudentVO> list = studentService.getStudentList();
		for(StudentVO std : list) {
			//System.out.println(std);
		}                    
		//1학년 1반 1번 학생을 가져와서 확인하는 코드
		StudentVO std = studentService.getStudent(1,1,1);
		//System.out.println(std); 
		//1학년 1반 1번 학생을 가져와서 확인하는 코드
		StudentVO std2 = studentService.getStudent(new StudentVO(0,1,1,1,null));
		//System.out.println(std2); 
		/*등록된 모든 과목을 가져와서 콘솔창에 확인하는 코드*/
		List<SubjectVO> sj_list = subjectService.getSubjectList();
		for(SubjectVO sj : sj_list) {
			System.out.println(sj_list);
			System.out.println("---------------");
		}
		/* 등록된 모든 성적을 가져오는 코드*/
		List<ScoreVO> scoreList = scoreService.getScoreList();
		for(ScoreVO sc : scoreList) {
			System.out.println(sc);
			System.out.println();
		}
		/*1학년 1반 1번의 학생의 등록된 성적들을 가져오느 코드~*/
		//1학년 1반 1번 학생의 정보를 가져옴
		StudentVO std3 = studentService.getStudent(1,1,1);
		//학생의 기본키를 이용하여 성적들을 가져옴
		List<ScoreVO> std_scoreList = scoreService.getStdScoreList(std3.getSt_key());
		//System.out.println(std3+"의 성적 목록");
		for(ScoreVO score : std_scoreList) {
			//System.out.println(score);
		}
		/*1학년 1반 1번 abc 학생을 등록*/
		StudentVO std4 = new StudentVO(0,1,1,11,"abc");
		if(studentService.addStudent(std4)) {
			System.out.println("학생을 등록 했습니다.");
			System.out.println(std4.getSt_key());
		}else
			System.out.println(std4+"학생을 등록하지 못했습니다");
		/*1학년 1반 1번 학생의 이름을 111로 수정*/
		StudentVO std5 = new StudentVO(1,1,1,1,"111");
		if(studentService.updateStudentName(std5)) {
			System.out.println(std5+"학생을 수정 했습니다.");
		}else
			System.out.println(std5+"수정하지 못 했습니다");
		
		if(studentService.deleteStudent(std4)) {
			System.out.println(std4+"학생을 삭제 했습니다.");
		}else
			System.out.println(std4+"삭제하지 못 했습니다");
	}

}
