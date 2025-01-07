package score;

public class StudentManager {
	private Student[] std = new Student[5];
	private int count =0;
	
	private void expend() {
		if(std==null)
			std= new Student[5];
		if(count < std.length)
			return;
		Student tmp[] = new Student[std.length+5];
		System.arraycopy(std, 0, tmp, 0, std.length);
	}
	void insertStudent(String name, int score) {
		std[count++] = new Student(name,score);
		expend();
	}
	 void printStudent() {
		int res=0;
		for(int i=0; i <count; i++) {
			std[i].print();
			res+=std[i].getScore();
		}
		double ave = res / (double) count;
		System.out.println("평균"+ave);
	}
}
