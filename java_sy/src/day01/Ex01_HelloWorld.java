package day01;

import java.util.Scanner;

public class Ex01_HelloWorld {
	private String name;
	private int kcal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	@Override
	public String toString() {
		return name+"의 칼로리: "+kcal;
	}
	
}
