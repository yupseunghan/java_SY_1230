package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.LikeVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostDAO postDao;
	
	@Resource
	private String uploadPath;

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		return postDao.selectPostList(cri);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return postDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(String bo_name) {
		if(bo_name == null || bo_name.trim().length() == 0) {
			return false;
		}
		try {
			//bo_name이 중복된 경우 예외 발생 => 추가 실패 => return false;
			return postDao.insertBoard(bo_name);
		}catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBoard(int bo_num) {
		return postDao.deleteBoard(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board == null || board.getBo_name() == null || board.getBo_name().trim().length() == 0) {
			return false;
		}
		return postDao.updateBoard(board);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(	post == null || 
			post.getPo_title().trim().length() == 0 || 
			post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		boolean res = postDao.insertPost(post);
		
		if(!res) {
			return false;
		}
		
		if(fileList == null || fileList.length == 0) {
			return true;
		}
		
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		return true;
	}

	private void uploadFile(MultipartFile file, int po_num) {
		String fi_ori_name = file.getOriginalFilename();
		//파일명이 없으면
		if(fi_ori_name == null || fi_ori_name.length() == 0) {
			return;
		}
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
			FileVO fileVo = new FileVO(fi_ori_name, fi_name, po_num);
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}

	@Override
	public boolean deletePost(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글 정보를 가져옴
		PostVO post = postDao.selectPost(po_num);
		//게시글의 작성자와 회원이 다르면 false 리턴
		if(post == null || !post.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글 수정
		boolean res = postDao.deletePost(po_num);
		
		if(!res) {
			return false;
		}
		//첨부파일 삭제
		List<FileVO> fileList = postDao.selectFileList(po_num);
		
		if(fileList == null || fileList.size() == 0) {
			return true;
		}
		
		for(FileVO fileVo : fileList) {
			deleteFile(fileVo);
		}
		//db에서 해당 첨부파일을 삭제
		return true;
	}

	private void deleteFile(FileVO fileVo) {
		if(fileVo == null) {
			return;
		}
		//실제 첨부파일을 삭제
		UploadFileUtils.deleteFile(uploadPath, fileVo.getFi_name());
		
		//db에서 해당 첨부파일을 삭제
		postDao.deleteFile(fileVo.getFi_num());
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user, MultipartFile[] fileList, int[] delNums) {
		if(	post == null || 
			post.getPo_title().trim().length() == 0 || 
			post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//작성자인지 확인
		//게시글 정보를 가져옴
		PostVO dbPost = postDao.selectPost(post.getPo_num());
		//게시글의 작성자와 회원이 다르면 false 리턴
		if(dbPost == null || !dbPost.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		boolean res = postDao.updatePost(post);
		
		if(!res) {
			return false;
		}
		
		if(fileList == null || fileList.length == 0) {
			return true;
		}
		//새 첨부파일 추가
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		
		if(delNums == null || delNums.length == 0) {
			return true;
		}
		//x버튼 눌러서 제거한 첨부파일 제거
		for(int fi_num : delNums) {
			FileVO fileVo = postDao.selectFile(fi_num);
			deleteFile(fileVo);
		}
		
		return true;
	}

	@Override
	public void updateView(int po_num) {
		postDao.updateView(po_num);
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		return postDao.selectFileList(po_num);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		int totalCount = postDao.selectCountPostList(cri);
		return new PageMaker(3, cri, totalCount);
	}

	@Override
	public int updateLike(LikeVO like, MemberVO user) {
		if(like == null || user == null) {
			return -2;
		}
		
		like.setLi_me_id(user.getMe_id());
		//기존 추천 정보를 가져옴
		LikeVO dbLike = postDao.selectLike(like);
		System.out.println(dbLike);
		//없으면 추가
		if(dbLike == null) {
			boolean res = postDao.insertLike(like);
			if(!res) {
				return -2;
			}
			return like.getLi_state();
		}
		//있으면 취소, 추천->비추천, 비추천->추천
		//취소하는 경우,
		if(dbLike.getLi_state() == like.getLi_state()) {
			like.setLi_state(0);
		}
		
		boolean res = postDao.updateLike(like);
		if(!res) {
			return -2;
		}
		return like.getLi_state();
	}

	@Override
	public void updateUpDown(int po_num) {
		postDao.updateUpDown(po_num);
	}

	@Override
	public LikeVO getLike(int po_num, MemberVO user) {
		if(user == null) {
			return null;
		}
		
		LikeVO like = new LikeVO();
		like.setLi_me_id(user.getMe_id());
		like.setLi_po_num(po_num);
		
		return postDao.selectLike(like);
	}

		
}
