package db.ex1.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentVO {	
	private int st_key;
	private int st_grade;
	private int st_class;
	private int st_num;
	private String st_name;
	@Override
	public String toString() {
		return st_grade+"학년 "+st_class+"반 "+st_num+"번 "+st_name;
	}
}
