package day02;

import java.util.Scanner;

public class Ex15_SwitchGrade {
	//메인메서드에서 탈출 return switch작동 x
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char grade = 0;
		System.out.println("성적을 입력해주세요: ");
		int score=sc.nextInt();
		if(score>=110 || score <0) {
			System.out.println("잘못된 성적입력");
			return;
		}
		switch(score/10) {
		case 10: grade='A'; break;
		case 8: grade='B'; break;
		case 7: grade='C'; break;
		case 6: grade='D'; break;
		default: grade='F';
		}
		System.out.println("당신의 학점: "+grade);
	}

}
