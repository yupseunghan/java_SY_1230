package day05;

public class Ex10_ArraySearch {
//배열이 다 지나가고 있다 없다가 딱 한번 씩 나오려고 할 때는 boolean 변수 활용
	public static void main(String[] args) {
		int[] array= new int[] {1,2,3,4,5};
		int num=4;
		if(contains(array,num))
			System.out.println(num+"은 있다");
		else
			System.out.println(num+"은 없다");
		
		if(contains(array,3,num))
			System.out.println(num+"은 배열에 3개 안에 있다");
		else
			System.out.println(num+"은 없다");
		
	}
	public static boolean contains(int[] arr,int num) {
		
		for(int i=0;i<arr.length;i++) if(num==arr[i]) return true;
		return false;
	}
	public static boolean contains(int[] arr,int count,int num) {
		if(arr.length<count)
			count =arr.length;
		for(int i=0;i<count;i++) {
			if(num==arr[i]) return true;
		}
		return false;
	}
}
