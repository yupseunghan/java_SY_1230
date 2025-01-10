package day09;

import java.util.Scanner;

public class Ex02_String2 {

	public static void main(String[] args) {
		/* 파일명을 수정하는 기능을 구현
		 * 기존 파일명을 입력 받고(확장자 포함)
		 * 수정하려는 파일명을 입력받아 (확장자 제외)
		 * 파일명을 수정하세요
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력: ");
		String prefile = sc.nextLine();
	
		int index = prefile.lastIndexOf(".");
		if(index <0) {
			System.out.println("확장자가 없는 파일명입니다");
			return;
		}
		
		System.out.print("수정: ");
		String newfile = sc.nextLine();

		String oriName = prefile.substring(0,index);
		prefile = prefile.replace(oriName,newfile);
		System.out.println("결과: "+prefile);
	}
}
