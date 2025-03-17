package kr.kh.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	private String name;
	private int age;
	@Override
	public String toString() {
		return "이름: "+name+" 나이: "+age;
	}
	
	
}
