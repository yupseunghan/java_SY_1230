package day10;

import java.util.HashSet;
import java.util.Random;

public class Ex05_Set2 {

	public static void main(String[] args) {
		//1에서 9사이의 랜덤한 수를 생성하여 중복되지 않게 3개 만드는 코드
		HashSet<Integer> set = new HashSet<>();
		int max=9,min=1;
		Random random = new Random();
		while(set.size()<3) {
			int n = random.nextInt(max-min+1)+min;
			set.add(n);
		}
		System.out.println("중복되지 않은 랜덤한 수 3개: "+set);
		
	}

}
