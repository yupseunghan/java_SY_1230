package day06.hanscore;

public class Student {
	private String name;
	private int score;
	Student(String name, int score){
		this.setName(name);
		this.setScore(score);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
