package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.StudentVO;

public interface StudentDAO {

	List<StudentVO> selectStduentList();

	StudentVO selectStduent(@Param("grade")int grade, @Param("classNum")int classNum, @Param("num")int num);

	StudentVO selectStudent2(@Param("std")StudentVO studentVO);

	boolean insertStudent(@Param("std")StudentVO std4);

	boolean updateStudentName(@Param("std")StudentVO std5);

	boolean deleteStudent(@Param("std")StudentVO std4);

}
