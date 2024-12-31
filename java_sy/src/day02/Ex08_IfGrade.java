package day02;

public class Ex08_IfGrade {

	public static void main(String[] args) {
		int score = 80,score1 =66;
		if(score>=90 && score <=100) System.out.println("A");
		else if(score <90 && score >=80) System.out.println("B");
		else if(score <80 && score  >=70) System.out.println("C");
		else if(score <70 && score >=60) System.out.println("D");
		else if(score < 60 && score>=0) System.out.println("F");
		else System.out.println("점수를 잘못 적었네요");
	
		if(score1 <0 || score1 >100) System.out.println("잘못된 점수");
		else if(score1 >90) System.out.println("A");
		else if(score1 >80) System.out.println("B");
		else if(score1 >70) System.out.println("C");
		else if(score >60) System.out.println("D");
		else System.out.println("F");
	}
}
