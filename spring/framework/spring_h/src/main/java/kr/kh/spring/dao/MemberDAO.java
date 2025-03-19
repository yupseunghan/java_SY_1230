package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVo;

public interface MemberDAO {

	public boolean insertMember(@Param("member")MemberVo member);

	public MemberVo selectMember(@Param("me_id")String me_id);


}
