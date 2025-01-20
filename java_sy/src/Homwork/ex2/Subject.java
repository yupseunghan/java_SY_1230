package Homwork.ex2;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	private int grade,semester;
	private String name;
	public void print() {
		System.out.println("-----------------");
		System.out.println(grade+"학년 "+semester+"학기 "+name);
	}
}
