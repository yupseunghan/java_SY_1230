package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVo;
import kr.kh.spring.model.vo.PostVo;

@Service
public class PostServiceImp implements PostService{
	@Autowired
	private PostDAO postDao;
	
	@Override
	public List<PostVo> getPostList() {
		return postDao.getPostList();
	}

	@Override
	public List<BoardVo> getBoardList() {
		return postDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(String bo_name) {
		if(bo_name==null || bo_name.trim().length()==0)
			return false;
		try {
			return postDao.insertBoard(bo_name);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBoard(int bo_num) {
		return postDao.deleteBoard(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVo board) {
		if(board == null ||board.getBo_name() == null|| board.getBo_name().trim().length()==0)
			return false;
		
		return postDao.updateBoard(board);
	}


}
