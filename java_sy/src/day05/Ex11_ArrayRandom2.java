package day05;

public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		int[] array= new int[6];
		int max=7,min=1;
		int count=0;
		while(count < array.length) {
			int r =(int)(Math.random() * (max - min + 1)) + min;
			boolean res =false;
			for(int i=0;i<array.length;i++) {
				if(array[i]==r) {
					res=true;
					break;
				}
			}
			if(res) continue;
			array[count++]=r;
			
		}
		/*for(int i=0;i<array.length;i++) {
			array[i] =(int)(Math.random() * (max - min + 1)) + min;		
			for(int j=0;j<i;j++)
				if(array[i] == array[j]) {
					i--;
					break;
				} 
		}*/
		
		printArray(array);
		while(count < array.length) {
			int r =(int)(Math.random() * (max - min + 1)) + min;
			
			if(contains(array,r))
				continue;
			
		}
	}
	public static int[] createRandomArray(int max,int min,int size) {
		int[] array = new int[size];
		int count=0;
		while(count < array.length) {
			int r =(int)(Math.random() * (max - min + 1)) + min;
			
			if(contains(array,r))
			array[count]=r;
			count++;
		}
		return array;
	}
	public static boolean contains(int[] arr,int num) {
		
		for(int i=0;i<arr.length;i++) if(num==arr[i]) return true;
		return false;
	}
	public static void printArray(int[] array) {
		for(int i=0; i<array.length;i++) System.out.print(array[i]+" ");
	}
}
