package Homwork.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data //getter, setter , toString , equals 등을 제공
@RequiredArgsConstructor //NonNull이거나 상수인 변수로만 생성자 만듬
public class Student {
	@NonNull
	private int grade,classNum,num;
	@NonNull
	private String name;
	public void print() {
		System.out.println("------------------------------------");
		System.out.println(grade+"학년 "+classNum+"반 "+num+"번 "+name);
	}
	//학생 개인의 성적을 담고 있는 배열
	public List<SubjectScore> list = new ArrayList<SubjectScore>();
	
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

	public boolean insertScore(SubjectScore subjectScore) {
		if(list.contains(subjectScore)) {
			return false;
		}
		list.add(subjectScore);
		return true;
	}

	public void printScore(Subject setSub) {
		int index = list.indexOf(new SubjectScore(setSub,0));
		if(index <0) {
			System.out.println("일치하는 성적이 없습니다");
			return;
		}
		System.out.println(list.get(index));
	}

	public boolean updateScore(Subject setSub, SubjectScore newsbs) {
		if(setSub == null || newsbs == null)
			return false;
		//등록된 성적이 아니면
		if(list.contains(new SubjectScore(setSub,0))) 
			return false;
		//같은 과목을 수정하면
		if(setSub.equals(newsbs.getSubject())) {
			list.remove(newsbs);
			list.add(newsbs);
			return true;
		}
		//다른 과목을 수정하면
		//새 성적이 등록된 성적인지 확인
		if(list.contains(newsbs))
			return false;
		list.remove(new SubjectScore(setSub,0));
		list.add(newsbs);
		return true;
	}

	public boolean delScore(Subject setSub) {
		
		return list.remove(new SubjectScore(setSub,0));
	}
}
