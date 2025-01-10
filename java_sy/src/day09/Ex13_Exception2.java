package day09;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class Ex13_Exception2 {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		arr = expend(arr,5);
		System.out.println(Arrays.toString(arr));

		try {
			//arr = expend(arr, -10);
			arr=null;
			arr=expend(arr,10);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("프로그램 종료");
	}
	public static int[] expend(int[] arr , int addSize) {
		//arr 배열에 addSize만큼 크기를 늘려서 새로운 배열을 만들어 반환
		//예외는 처리
		if(addSize < 0) 
			throw new RuntimeException("배열을 축소 할 수 없습니다.");
		if(arr == null)
			throw new NullPointerException("없는 배열을 확장 할 수 없습니다");
		int[] tmp =  new int[arr.length+addSize];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		return tmp;
	}
}
