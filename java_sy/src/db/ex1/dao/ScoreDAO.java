package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.ScoreVO;

public interface ScoreDAO {

	List<ScoreVO> selectScoreList();

	List<ScoreVO> selectStdScoreList(@Param("st_key")int st_key);

}
