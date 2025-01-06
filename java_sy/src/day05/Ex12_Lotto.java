package day05;

import java.util.Scanner;

public class Ex12_Lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int min =1, max=7,bonus=0;
		int[] lotto = createRandomArray(min, max, 6);//랜덤 배열 메서드 생성   o
		int [] mylotto = new int[6];
		printArray(lotto);//배열 출력 메서드 생성    o
		do {
			bonus=(int)(Math.random()*(max-min+1)+min);
		}while(contains(lotto, bonus)); // 배열 메게변수에 메게변수 정수가 있으면 트루인 메서드 생성     o
		System.out.println("\n Bonus:"+bonus);
		for(int i=0; i<mylotto.length;i++) {
			System.out.print((i+1)+"번째 로또 번호 입력: ");
			mylotto[i]=sc.nextInt();
		}
		int count=0;
		for(int i=0; i<lotto.length;i++) {
			if(contains(mylotto, lotto[i]))
				count++;
		}
		switch(count) {
		case 6 : System.out.println("1등"); break;
		case 5 : if(Ex11_ArrayRandom2.contains(mylotto, bonus)) {
			System.out.println("2등"); break;
		}else System.out.println("3등"); break;
		case 4 : System.out.println("4등"); break;
		case 3 : System.out.println("5등"); break;
		default : System.out.println("꽝");
		}
	}
	
	public static boolean contains (int[] arr, int n) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n) return true;
		}
		return false;
	}
	
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
	}
	
	public static int[] createRandomArray(int min, int max, int size) {
		int array[] = new int[size];
		int count=0;
		while(count<array.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean res = false;
			for(int i=0; i<array.length;i++) {
				if(array[i]==r) {
					res=true;
					break;
				}
			}
			if(res) continue;
			array[count++]=r;
		}
		return array;
	}
}
