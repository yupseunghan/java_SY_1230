package day06;

public class Ex05_EnhancedFor {

	public static void main(String[] args) {
		int[] arr = new int[] {1,5,10,2,3};
		print(arr);
	}
	public static void print(int []arr) {
		for(int tmp:arr) 
			System.out.print(tmp+" ");
		System.out.println();
	}
}
