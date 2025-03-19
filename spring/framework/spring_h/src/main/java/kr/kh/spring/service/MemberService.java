package kr.kh.spring.service;

import kr.kh.spring.model.vo.MemberVo;

public interface MemberService {

	boolean singup(MemberVo member);

	MemberVo login(MemberVo member);

}
