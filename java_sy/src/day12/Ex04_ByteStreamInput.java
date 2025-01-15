package day12;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Ex04_ByteStreamInput {

	public static void main(String[] args) {
		FileInputStream fis =null;
		/*경로는 절대 경로와 상대 경로가 있다
		 * 절대 경로: 현재 파일위치와 상관없는 경로
		 * -D:\dev\jdk
		 * 상대 경러 : 현재 파일 위치에 따라 경로가 달라짐
		 * -lombok.jar
		 * -src/day12/test.txt*/
		try {
			fis = new FileInputStream("src/day12/byte_stream.txt");
			/*int data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);
			data =fis.read();
			System.out.println((char)data);*/
			int data;
			do{
				data = fis.read();
				char ch = (char)data;
				if(data!=1)
					System.out.print((char)data);
			}while(data!=-1);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 비어있습니다");
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
