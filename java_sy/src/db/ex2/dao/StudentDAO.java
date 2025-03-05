package db.ex2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.StudentVO;
import db.ex2.model.vo.Student;

public interface StudentDAO {

	Student selectStudent(@Param("std")Student setStd);

	boolean insertStudent(@Param("std")Student setStd);

	boolean updateStudent(@Param("old")Student oldStd,@Param("new") Student newStd);

	boolean deleteStudent(@Param("std")Student setStd);


}
