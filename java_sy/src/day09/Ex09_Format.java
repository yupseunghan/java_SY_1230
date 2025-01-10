package day09;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Ex09_Format {

	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat("000,000");
		int num=12345;
		System.out.println(format.format(num));
		
		String message="{0} : {1}";
		String name="홍길동";
		int score =100;
		String res = MessageFormat.format(message,name,score);
		System.out.println(res);
	}

}
