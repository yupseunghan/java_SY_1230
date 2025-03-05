package db.ex2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.SubjectVO;
import db.ex2.model.vo.Subject;

public interface SubjectDAO {

	Subject selectSubject(@Param("sub")Subject subject);

	boolean insertSubject(@Param("sub")Subject subject);

	boolean deleteSubject(@Param("sub")Subject subject);

	boolean updateSubject(@Param("old")Subject subject,@Param("new")Subject newSubject);

	List<Subject> selectSubjectList();

	

}
