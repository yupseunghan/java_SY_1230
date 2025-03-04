package db.ex1.model.vo;

import lombok.Data;

@Data
public class SubjectVO {
	private int sj_num;
	private int sj_grade;
	private String sj_semester;
	private String sj_name;
	@Override
	public String toString() {
		return sj_grade+"학년 "+sj_semester+"학기 "+sj_name;
	}
	
}
