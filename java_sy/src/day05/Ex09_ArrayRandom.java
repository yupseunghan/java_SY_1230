package day05;

public class Ex09_ArrayRandom {
//Math.random 은 더블형 int로 강제 형변환을 시켰으니 0 ~ 0.9999 이므로 *100을 해야함
	public static void main(String[] args) {
		int [] arr = createRandomArray(10, 1, 6);
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
	}
	public static int[] createRandomArray(int max,int min,int size) {
		int[] randomArray = new int[size];
		for(int i=0;i<size;i++) randomArray[i] = (int)(Math.random() * (max - min + 1)) + min;
		return randomArray;
	}
}
