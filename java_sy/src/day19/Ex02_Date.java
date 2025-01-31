package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Ex02_Date {

	public static void main(String[] args) {
		//날짜 형태인지 판별 yyyu-MM-dd 형태만 날짜로 판별
		String str1= "2025-01-27";//o
		String str2="25-01-27";//x
		String str3 ="2025-01-32";
		System.out.println(isDate1(str1));
		System.out.println(isDate1(str2));
		System.out.println(isDate1(str3));
		System.out.println("----------------");
		System.out.println(isDate2 (str1));
		System.out.println(isDate2(str2));
		System.out.println(isDate2(str3));
	}
	public static boolean isDate1(String str) {
		try {
			String[] list = str.split("-");
			if(list.length==0)
				return false;
			if(list[0].length() != 4)
				return false;
			new SimpleDateFormat("yyyy-MM-dd").parse(str);
			return true;
		} catch (Exception e) {
			System.out.println("형태가 이상함");
			return false;
		}
	}
	public static boolean isDate2(String str) {
		String regex ="^\\d{4}-\\d{2}-\\d{2}$";
		return Pattern.matches(regex, str);
	}
	public static boolean isDate3(String str) {
		String[] list =str.split("-");
		if(list.length !=3)
			return false;
		try {
			if(list[0].length() != 4 || list[1].length() != 2|| list[2].length() != 2) {
				return false;
			}
			int year = Integer.parseInt(list[0]);
			int month = Integer.parseInt(list[0]);
			int day = Integer.parseInt(list[0]);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
