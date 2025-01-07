package day06;

public class Ex02_ArrayMax {

	public static void main(String[] args) {
		int[] arr = new int[] {-1,-2,-3,-6,-5};
		int res=arr[0];
		for(int i=1; i<arr.length;i++) {
			if(res<arr[i])
				res=arr[i];
				
		}
		System.out.println(res);
	}

}
