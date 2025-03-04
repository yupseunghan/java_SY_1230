package db.ex1.model.vo;

import lombok.Data;
	/*mybatis에서 자동으로 매핑을 할 때 다음과 같은 규칙
	 * 1.정확히 일치하면 가능
	 * 2.prefix를 생략하면 가능 -느슨한 매핑
	 * 3.유사한 필드명도 맵핑
	 * -autoMappingBehavior 속성 값에 따라 매칭 강도를 조절할 수 있음
	 * 	-FULL : 기본값. 1,2,3 다 가능
	 * -PARTIAL : 정확히 일치할때만 매핑
	 * */
@Data
public class ScoreVO {
	private SubjectVO subject;
	private int sc_num;
	private int sc_score;
	private int sc_st_key;
	private int sc_sj_num;
	@Override
	public String toString() {
		return subject+" : "+sc_score+"점";
	}
	
}
