package day09;

public class Ex01_String {

	public static void main(String[] args) {
		String fileName ="text.gif";
		String[] imgs = new String[] {"jpg","bmp","gif","png"};
		boolean img = false;
		int index= fileName.lastIndexOf(".");
		//파일명에 .이 없는지 비교
		if(index<0) {
			System.out.println(fileName+"은 이미지 파일이 아닙니다");
			return;
		}
		//파일 이름에서 .기준 뒤 3글자 
		// 3글자를 이미지 배열과 비교
		//비교 후 판별
		for(String file:imgs) {
			if(file.equals(fileName.substring(index+1))) {
				img=true;
				break;
			}
		}
		System.out.println(img ? fileName+"은 이미지 파일이 맞습니다" : fileName+"은 이미지 파일이 아닙니다");
	}

}
