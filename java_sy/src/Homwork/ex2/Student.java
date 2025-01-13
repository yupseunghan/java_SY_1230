package Homwork.ex2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter , toString , equals 등을 제공
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private int grade,classnum,num;
	private String name;
}
