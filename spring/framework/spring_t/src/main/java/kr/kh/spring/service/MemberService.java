package kr.kh.spring.service;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	boolean checkId(String id);

	void updateCookie(MemberVO user);

	MemberVO getMemberByCookie(String cookieId);

	boolean findPw(String id);

	boolean updateMember(MemberVO user, MemberVO member);

}
