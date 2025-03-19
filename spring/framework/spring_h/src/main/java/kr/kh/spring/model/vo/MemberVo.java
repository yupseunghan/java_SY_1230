package kr.kh.spring.model.vo;

import lombok.Data;

@Data
public class MemberVo {
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_authority;
}
