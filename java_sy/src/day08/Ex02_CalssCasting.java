package day08;

import day08.day08.ex02.BenzCar;
import day08.day08.ex02.Car;
import day08.day08.ex02.KiaCar;

public class Ex02_CalssCasting {

	public static void main(String[] args) {
		Car[] list = new Car[10];
		//업캐스팅 자동 클래스 변환
		list[0] = new BenzCar();
		list[1] = new KiaCar();
		int count=2;
		for(int i=0;i<count;i++){
			Car tmp = list[i];
			if(tmp instanceof KiaCar) {
				KiaCar kiatmp = (KiaCar) tmp;
				System.out.println(kiatmp.logo);
			}else if(tmp instanceof BenzCar) {
				System.out.println(((BenzCar)tmp).logo);
			}
		}
	}

}
