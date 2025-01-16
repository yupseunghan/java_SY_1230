package day13;

import java.io.File;
import java.io.IOException;

public class Ex02_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName =  "D:\\git\\test.txt";
		File file = new File(fileName);
		
		if(file.exists()) {
			System.out.println("존재합니다");
			if(file.isDirectory())
				System.out.println("폴더입니다");
			else if(file.isFile())
				System.out.println("파일입니다");
			return;
		}
	}
}
