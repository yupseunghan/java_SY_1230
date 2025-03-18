package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring.model.vo.PostVo;
import kr.kh.spring.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	@GetMapping("/post/list")
	public String postList(Model model) {
		//게시글 목록 전체를 가져옴
		List<PostVo> list = postService.getPostList();
		//화면에 게시글 목록을 전송
		model.addAttribute("list",list);
		return"/post/list";
	}
}
