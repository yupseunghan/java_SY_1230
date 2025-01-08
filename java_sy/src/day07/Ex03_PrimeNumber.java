package day07;

public class Ex03_PrimeNumber {

	public static void main(String[] args) {
		int num =10,num2=7;
		int i;
		for(i=2;i<num;i++)
			if(num % 1 ==0) break;
		if(i == num)
			System.out.println(num + " 은 소수");
		else
			System.out.println(num + " 은 소수x");
		if(isPrime(num2))
			System.out.println(num2 + " 은 소수");
		else
			System.out.println(num2 + " 은 소수x");
		
		boolean[] primeArray = new boolean[101];
		for(i=1;i<primeArray.length;i++) {
			if(isPrime(i))
				primeArray[i] =true;
			else
				primeArray[i] =false;
		}
		
		for(i=1;i<primeArray.length;i++)
			if(primeArray[i])
				System.out.print(i+" ");
				
	}
	public static boolean isPrime(int n) {
	    if (n <= 1) return false;  
	    if (n == 2) return true;  
	    if (n % 2 == 0) return false; 

	    // n 의 제곱근까지 홀수로만 검사
	    for (int i = 3; i * i <= n; i += 2) {
	        if (n % i == 0) return false;  // 나누어떨어지면 소수가 아님
	    }

	    return true;  // 나누어떨어지지 않으면 소수
	}
}
