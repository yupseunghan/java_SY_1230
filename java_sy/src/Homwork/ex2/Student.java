package Homwork.ex2;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter , toString , equals 등을 제공
@AllArgsConstructor
public class Student {
	private int grade;
	private int classNum;
	private int num;
	private String name;
	public Student(int grade, int classNum, int num, String name) {
		this.grade=grade;
		this.classNum=classNum;
		this.num=num;
		this.name=name;
	}
	@Override
	public String toString() {
		return grade+"학년 "+classNum+"반 "+num+"번 이름: "+name;
	}
	//학생 개인의 성적을 담고 있는 배열
	public List<SubjectScore> list;
	
	//equals를 오버라이딩, 학년, 반, 번호를 이용
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return grade == student.grade && classNum == student.classNum && num == student.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, classNum, num);
    }
}
