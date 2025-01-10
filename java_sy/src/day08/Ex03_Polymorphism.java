package day08;

import day08.day08.ex02.BenzCar;
import day08.day08.ex02.Car;
import day08.day08.ex02.KiaCar;

public class Ex03_Polymorphism {

	public static void main(String[] args) {
		KiaCar kia = new KiaCar();
		BenzCar benz = new BenzCar();
		
		repair(benz);
		repair(kia);
	}
	public static void repair(Car car) {
		car.repair();
	}
}
