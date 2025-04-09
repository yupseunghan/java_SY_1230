package kr.kh.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.LikeVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;

public interface PostService {

	List<PostVO> getPostList(Criteria cri);

	List<BoardVO> getBoardList();

	boolean insertBoard(String bo_name);

	boolean deleteBoard(int bo_num);

	boolean updateBoard(BoardVO board);

	boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList);

	PostVO getPost(int po_num);

	boolean deletePost(int po_num, MemberVO user);

	boolean updatePost(PostVO post, MemberVO user, MultipartFile[] fileList, int[] delNums);

	void updateView(int po_num);

	List<FileVO> getFileList(int po_num);

	PageMaker getPageMaker(Criteria cri);

	int updateLike(LikeVO like, MemberVO user);

	void updateUpDown(int li_po_num);

	LikeVO getLike(int po_num, MemberVO user);

	

}
