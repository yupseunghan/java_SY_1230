package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.PostVo;

@Service
public class PostServiceImp implements PostService{
	@Autowired
	private PostDAO postDao;
	
	@Override
	public List<PostVo> getPostList() {
		return postDao.getPostList();
	}


}
