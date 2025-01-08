package day07;

public class Ex02_For {

	public static void main(String[] args) {
		int sum=0,min=1,max=10;
		for(int i=min;i<=max;i++) 
			sum += i;
		System.out.println(sum);
		sum=0;
		for(int i=min;i<=max;i++) {
			if(i%2!=0)
				sum += i;
			else
				sum -= i;
		}
		System.out.println(sum);
	}

}
