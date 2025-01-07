package day06;

public class Ex03_ArrayCopy {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,3,5,4,9};
		int[] arr2;
		arr2 = new int[arr1.length];
		for(int i=0;i<arr1.length;i++) {
			arr2[i]=arr1[i];
		}
		printArr(arr1);
		printArr(arr2);
		arr2[0]=3;
		System.out.println("-----------");
		printArr(arr1);
		printArr(arr2);
		int[] arr3 = new int[arr2.length];
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		printArr(arr3);
	}
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length;i++ )
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
