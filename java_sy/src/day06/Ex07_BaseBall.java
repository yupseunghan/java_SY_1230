package day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07_BaseBall {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int[] base = createRandom(1, 9, 3);
		int[] mybase = new int[base.length];
		int strike,ball;
		System.out.print("랜덤 수: ");
		System.out.println(Arrays.toString(base));
		
		do {
			strike=0;
			ball=0;
			
			input(mybase);
			
			strike=getStrike(base, mybase);
			ball=getBall(base, mybase);
			
			printRes(strike,ball);
		}while(strike<3);
		
		System.out.println("프로그램을 종료합니다");
		
	}
	private static void printRes(int strike, int ball) {
		if(strike!=0)
			System.out.print(strike+"S");
		if(ball!=0)
			System.out.print(ball+"B");
		if(strike==0 && ball==0)
			System.out.println("3O");
		System.out.println();
		
	}
	public static void input(int[]arr) {
		System.out.print("입력: ");
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
	}
	public static int getBall(int[] arr,int[] arr2) {
		int count=0;
		for(int tmp:arr) {
			if(contains(arr2,tmp))
				count++;
		}
		return count-getStrike(arr, arr2);
	}
	private static boolean contains(int[] arr, int n) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n)
				return true;
		}
		return false;
	}
	public static int getStrike(int[]arr , int[] arr2) {
		int st=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==arr2[i])
				st++;
		}
		return st;
	}
	public static int[] createRandom(int min,int max,int size) {
		if((max-min+1)<size || size<=0)
			return null;
		if(max<min) {
			int tmp=0;
			tmp=min;
			min=max;
			max=min;
		}
		int[] arr = new int[size];
		int count = 0;
		while(count<arr.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean res= false;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==r) {
					res=true;
					break;
				}
			}
			if(!contains(arr,r))
			arr[count++]=r;
		}
		return arr;
	}
}
