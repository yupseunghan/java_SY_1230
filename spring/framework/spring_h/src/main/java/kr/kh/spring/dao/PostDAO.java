package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVo;
import kr.kh.spring.model.vo.PostVo;

public interface PostDAO {

	List<PostVo> selectPostList();

	List<BoardVo> selectBoardList();

	boolean insertBoard(@Param("bo_name")String bo_name);

	boolean deleteBoard(@Param("bo_num")int bo_num);

	boolean updateBoard(@Param("board")BoardVo board);

	List<PostVo> getPostList();

	
	
}