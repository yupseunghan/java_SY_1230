package day05;

import java.util.Scanner;

public class Ex08_Array {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int res=0;
		int student=3;
		int[] score = new int[student];
		for(int i=0;i<student;i++) {
			System.out.print((i+1)+"번째 학생 점수 입력: ");
			score[i]=sc.nextInt();
		}
		
		for(int i=0;i<student;i++) System.out.println((i+1)+"번째 학생 점수: "+score[i]);
		for(int i=0;i<student;i++) res += score[i];

		System.out.println(score.length+"학생 평균: "+((double)res/score.length));
	}

}
