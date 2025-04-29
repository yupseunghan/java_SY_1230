package kr.kh.boot.model.vo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class CustomUser extends User {
	
	private MemberVO member;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	public CustomUser(MemberVO vo) {
		this(	vo.getMe_id(),
			vo.getMe_pw(), 
			Arrays.asList(new SimpleGrantedAuthority(vo.getMe_authority())));
		this.member = vo;
	}
}
