package day05;

import java.util.Scanner;

public class Ex03_Class {

	public static void main(String[] args) {
		String name="임꺽정";
		int count =100;
		System.out.println("이름 "+name+" - "+count+"회");
		record1(name,count);
		System.out.println("이름 "+name+" - "+count+"회");
		
		Record r1 = new Record(name,count);
		r1.print();
		record2(r1);
		r1.print();
	}
	public static void record1(String name , int count) {
		name ="홍길동";
	
	}
	public static void record2(Record r1) {
		r1.setName("홍길동");
		r1.setCount(2);
	}
}
class Record{
	private int count;
	private String name;
	Record(String name, int count){
		this.count=count;
		this.name=name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println("이름 "+name+" - "+count+"회");
	}
}
