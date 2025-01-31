package day18;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;



public enum Bank{
	신한,국민,우리;
	public static void printBanks() {
		Bank[] list = Bank.values();
		for(int i=0;i<list.length;i++) {
			System.out.println((i==0?"":", ")+list[i]);
		}
		System.out.println();
	}
	public static boolean check(String str) {
		try {
			Bank bank=Bank.valueOf(str);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
}
