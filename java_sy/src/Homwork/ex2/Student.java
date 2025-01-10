package Homwork.ex2;

import lombok.Data;

@Data //getter, setter , toString , equals 등을 제공
public class Student {
	Subject[] sb;
	int grade,classnum,num;
	String name;
}
