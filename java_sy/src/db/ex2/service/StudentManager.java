package db.ex2.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex2.dao.ScoreDAO;
import db.ex2.dao.StudentDAO;
import db.ex2.dao.SubjectDAO;
import db.ex2.model.vo.Student;
import db.ex2.model.vo.Subject;
import db.ex2.model.vo.SubjectScore;
import lombok.Data;

@Data
public class StudentManager {
	private List<Student> list;
	private StudentDAO studentDao;
	private ScoreDAO scoreDao;
	private SubjectDAO subjectDao;
	public StudentManager() {
		String resource = "db/ex2/config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
			scoreDao = session.getMapper(ScoreDAO.class);
			subjectDao = session.getMapper(SubjectDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean insertStudent(Student setStd) {
		if(setStd == null) 
			return false;
		//학생 중복 확인
		if(contains(setStd))
			return false;
		//학생이 중복되지 않으면 학생 추가
		return studentDao.insertStudent(setStd);
	}

	public Student getStudent(Student setStd) {
		return contains(setStd) ? setStd : null;
	}

	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd == null || newStd == null)
			return false;
		//학년 반 번호가 같은 경우
		if(selStd.equals(newStd))
			return studentDao.updateStudent(newStd,newStd);
		//학년 반 번호가 다른 경우
		if(contains(newStd))
			return false;
		return studentDao.updateStudent(selStd,newStd);
	}
	public boolean contains(Student std) {
		Student dbStd = studentDao.selectStudent(std);
		if(dbStd != null)
			return true;
		return false;
	}
	public boolean delStudent(Student setStd) {
		if(setStd==null)
			return false;
		return studentDao.deleteStudent(setStd);
	}

	public void printStudent(Student std) {
		if(std==null)
			System.out.println("학생 정보가 없습니다");
		Student tmp = studentDao.selectStudent(std);
		if(tmp ==null) {
			System.out.println("일치하는 학생이 없습니다");
			return;
		}
		tmp.print();
	}
	public int getScoreNum(Student setStd, SubjectScore subjectScore) {
		if(setStd == null || subjectScore == null || subjectScore.getSubject() == null)
			return -1;
		//등록된 학생인지 확인
		Student dbStd = studentDao.selectStudent(setStd);
		if(dbStd==null)
			return -1;
		//등록된 과목인지 확인
		Subject dbSubject = subjectDao.selectSubject(subjectScore.getSubject());
		if(dbSubject==null)
			return -1;
		subjectScore.setKey(dbStd.getKey());
		subjectScore.getSubject().setNum(dbSubject.getNum());
		SubjectScore dbSubScore = scoreDao.selectScore(subjectScore);
		return dbSubScore != null ?  dbSubScore.getNum() : -1;
	}
	public boolean insertScore(Student setStd, SubjectScore subjectScore) {
		if(setStd == null || subjectScore ==null)
			return false;
		//새로 등록할 학생의 성적이 이미 등로고디어 있는지를 확인		
		if(getScoreNum(setStd, subjectScore) != -1)
			return false;
		return scoreDao.insertScore(subjectScore);
	}

	public boolean updateScore(Student std, Subject subject, SubjectScore subjectScore) {
		if(std == null || subject == null || subjectScore == null || subjectScore.getSubject()==null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		//std와 subject를 이용하여 기존 성적 정보를 가져옴~~~
		SubjectScore tmp = new SubjectScore(subject,0);
		int scNum =getScoreNum(std,tmp);
		if(scNum == -1)
			return false;
		Subject dbSubject = subjectDao.selectSubject(subjectScore.getSubject());
		if(dbSubject == null)
			return false;
		//현재 성적의 기본키를 가져옴
		subjectScore.setNum(scNum);
		//새 성적의 과목의 기본키를 가져옴
		subjectScore.getSubject().setNum(dbSubject.getNum());
		return scoreDao.updateScore(subjectScore);
	}

	public boolean deleteScore(Student std, Subject subject) {
		if (std == null || subject == null) {
			return false;
		}
		Student dbStd =studentDao.selectStudent(std);
		if(dbStd == null) {
			return false;
		}
		Subject dbSub =subjectDao.selectSubject(subject);
		if(dbSub==null)
			return false;
		return scoreDao.deleteScore(dbStd.getKey(),dbSub.getNum());
	}

	public void printScore(Student std, Subject subject) {
		if(std == null || subject == null ) {
			System.out.println("출력할 수 없습니다.");
			return ;
		}
		std = studentDao.selectStudent(std);
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		subject = subjectDao.selectSubject(subject);
		if(subject == null) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		SubjectScore tmp = new SubjectScore(new Subject(0,0,""),0);
		tmp.setKey(std.getKey());
		tmp.getSubject().setNum(subject.getNum());
		SubjectScore score = scoreDao.selectScore(tmp);
		if(score==null) {
			System.out.println("등록딘 성적이 없습니다.");
			return;
		}
		System.out.println(std +" "+score);
	}
}
