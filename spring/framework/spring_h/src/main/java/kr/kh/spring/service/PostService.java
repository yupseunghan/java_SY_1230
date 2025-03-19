package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.model.vo.BoardVo;
import kr.kh.spring.model.vo.PostVo;

public interface PostService {

	List<PostVo> getPostList();

	List<BoardVo> getBoardList();

	boolean insertBoard(String bo_name);

	boolean deleteBoard(int bo_num);

	boolean updateBoard(BoardVo board);


}
