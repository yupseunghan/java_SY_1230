package day06;

import java.util.Arrays;
import java.util.Collections;

public class Ex06_ArraySort {

	public static void main(String[] args) {
		//
		int[] arr = new int[] {1,3,5,7,9,2,4,6,8,10};
		System.out.println("오름");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("-------\n 내림");
		Integer[] arr2 = new Integer[] {1,3,5,7,9,2,4,6,8,10};
		Arrays.sort(arr2,Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
	}

}
