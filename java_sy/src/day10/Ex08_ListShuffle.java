package day10;

import java.util.ArrayList;
import java.util.Collections;

public class Ex08_ListShuffle {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<=10; i++) 
			list.add(i);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

}
