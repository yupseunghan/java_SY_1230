package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVo;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean singup(MemberVo member) {
		if(member == null) {
			return false;
		}
		//아이디 정규 표현식 체크
		//비번 정규 표현식 체크
		//이메일 정규 표현식 체크
		//가입된 아이디인지 확인
		MemberVo user = memberDao.selectMember(member.getMe_id());
		if(user != null) return false;
		String encodePw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encodePw);
		return memberDao.insertMember(member);
	}
	
	@Override
	public MemberVo login(MemberVo member) {
		if(member == null) {
			return null;
		}
		MemberVo user = memberDao.selectMember(member.getMe_id());
		//아이디가 일치하지 않을 때
		if(user == null) return null;
		//비번이 일치하지 않을 때
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))return null;
		//다 일치 할 떄 
		return user;
	}
	
}
