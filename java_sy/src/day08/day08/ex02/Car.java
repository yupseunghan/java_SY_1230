package day08.day08.ex02;

public class Car {
	private boolean poewr;
	protected int speed;
	public void turnOn() {this.poewr=true;}
	public void turnOff() {this.poewr=false;}
	
	public void speedUp() { speed++;}
	public void speedDown() { speed--;}
	public void repair() {
		System.out.println("수리합니다");
	}
}
