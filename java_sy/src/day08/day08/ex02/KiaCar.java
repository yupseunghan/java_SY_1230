package day08.day08.ex02;


public class KiaCar extends Car{
	public String logo ="기아";
	@Override
	public void repair() {
		System.out.println("기아를 수리합니다");
	}
}