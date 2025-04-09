package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

	MemberVO selectMember(@Param("me_id")String me_id);

	void updateCookie(@Param("user")MemberVO user);

	MemberVO selectMemberByCookie(@Param("me_cookie")String cookieId);

	void updatePw(@Param("me_id")String me_id, @Param("me_pw")String newPw);

	boolean updateMember(@Param("user")MemberVO user);

}
