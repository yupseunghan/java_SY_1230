package db.ex2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.ScoreVO;
import db.ex2.model.vo.Student;
import db.ex2.model.vo.SubjectScore;

public interface ScoreDAO {

	SubjectScore selectScore(@Param("score")SubjectScore subjectScore);

	boolean insertScore(@Param("score")SubjectScore subjectScore);

	boolean updateScore(@Param("score")SubjectScore subjectScore);

	boolean deleteScore(@Param("key")int key, @Param("num")int num);



	


}
