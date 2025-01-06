package day05;

import java.util.Scanner;

public class Solusion {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min =1, max =7, bonus=0,count=0;;
		int[] lotto= randomArray(1,7,6);
		int[] mylotto = new int[6];
		
		printArray(lotto);
		
		do {
			bonus = (int) (Math.random()*(max-min+1)+min);
		}while(contains(lotto,bonus));
		System.out.println("\n보너스: "+bonus);
		
		for(int i=0;i<mylotto.length;i++) {
			System.out.print((i+1)+"번째 번호 입력: ");
			mylotto[i] = sc.nextInt();
		}
		printArray(mylotto);
		
		for(int i=0;i<lotto.length;i++) {
			if(contains(mylotto,lotto[i])) {
				count++;
			}
		}
		switch(count) {
		case 6:System.out.println(" 1"); break;
		case 5:
			if(contains(mylotto,bonus)) {
				System.out.println(" 2");
				break;
			}else {
				System.out.println(" 3");
				break;
			}
		case 4:System.out.println(" 4"); break;
		case 3:System.out.println(" 5"); break;
		default: System.out.println("꽝");
		}
	}
	public static boolean contains(int[] arr, int n) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n)
				return true;
		}
		return false;
	}
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
	}
	public static int[] randomArray(int min,int max,int size) {
		int[] arr = new int[size];
		int count=0;
		while(count<arr.length) {
			int r= (int)(Math.random()*(max-min+1)+min);
			boolean res = false;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==r) {
					res=true;
					break;
				}
			}
			if(res) continue;
			arr[count++] =r;
		}
		return arr;
	}
}
