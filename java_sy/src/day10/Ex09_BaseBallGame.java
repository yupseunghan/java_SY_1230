package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Ex09_BaseBallGame {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int ball,strike;
		createRamdomList(1,9,3,list);
		System.out.println(list);
		do {
			ArrayList<Integer> myball = new ArrayList<>();
			ball=0; strike=0;
			System.out.print("3개의 정수 입력: ");
			for(int i=0;i<list.size();i++)
				myball.add(sc.nextInt());
			strike = getStrike(list,myball);
			ball = getBall(list,myball);
			printResult(strike,ball);
		}while(strike != 3);
		System.out.println("삼진 아웃");
		
	}
	private static void printResult(int strike, int ball) {
		if(strike != 0)
			System.out.print(strike+"S");
		if(ball != 0)
			System.out.print(ball+"B");
		if(strike==0 && ball==0)
			System.out.print("3O");
		System.out.println();
	}
	private static int getBall(ArrayList<Integer> list, ArrayList<Integer> myball) {
		int ball=0;
		for(int tmp:list) {
			if(myball.contains(tmp))
				ball++;
		}
		return ball - getStrike(list,myball);
	}
	private static int getStrike(ArrayList<Integer> list, ArrayList<Integer> myball) {
		int strike=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(myball.get(i))) {
				strike++;
			}
		}
		return strike;
	}
	private static void createRamdomList(int min, int max, int size, ArrayList<Integer> list) {
		HashSet<Integer> set = new HashSet<>();
		while(set.size()<size) {
			int n = (int)(Math.random() *(max-min+1)+min);
			set.add(n);
		}
        list.addAll(set);
        Collections.shuffle(list);
	}
}
