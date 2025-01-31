package day19;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {	
	private String name;
	private Check check;
	public Student(String name) {
		this.name=name;
		check = new Check();
	}
	@Override
	public String toString() {
		return check.getDstr()+" "+name+" : "+check.checked();
	}
	
}
