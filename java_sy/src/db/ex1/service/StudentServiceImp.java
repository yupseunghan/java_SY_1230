package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.StudentDAO;
import db.ex1.model.vo.StudentVO;

public class StudentServiceImp implements StudentService{
	StudentDAO studentDao;
	public StudentServiceImp() {
		String resource = "db/ex1/config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<StudentVO> getStudentList() {
		return studentDao.selectStduentList();
	}
	@Override
	public StudentVO getStudent(int grade, int classNum, int num) {
		return studentDao.selectStduent(grade,classNum,num);
	}
	@Override
	public StudentVO getStudent(StudentVO studentVO) {
		if(studentVO == null)
			return null;
		return studentDao.selectStudent2(studentVO);
	}
	@Override
	public boolean addStudent(StudentVO std4) {
		StudentVO dbStd = studentDao.selectStudent2(std4);
		if(dbStd!=null)
			return false;
		return studentDao.insertStudent(std4);
	}
	@Override
	public boolean updateStudentName(StudentVO std5) {
		if(std5==null)
			return false;
		return studentDao.updateStudentName(std5);
	}
	@Override
	public boolean deleteStudent(StudentVO std4) {
		if(std4 == null)
			return false;
		return studentDao.deleteStudent(std4);
	}
}
