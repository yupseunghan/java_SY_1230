package day08;

public class Ex10_String {

	public static void main(String[] args) {
		String str="abc";
		System.out.println(str+"에서 3번째 글짜는 ?"+str.charAt(3-1));
		
		String str2 = new String ("abc");
		System.out.println(str+".equals("+str2+") :"+str.equals(str2));
		System.out.println(str+" == "+str2+" : "+(str==str2));
		
		String str3 ="Hello world";
		String search = "l";
		
		int index =str3.indexOf(search);
		System.out.println(str3+"에서 첫번째 "+search+"의 위치는? "+index+"번진");
		
		index = str3.lastIndexOf(search);
		System.out.println(str3+"에서 마지막 "+search+"의 위치는? "+index+"번지");
		//contains 문자열이 있는지 없는지 알려줌
		System.out.println(str3+"에 "+search+"가 있습니까? "+ str3.concat(search));
	
		System.out.println(str3+"의 길이"+str3.length());
		
		String str4 = "I love C언어. C언어는 최고";
		String str5 = str4.replace("C언어","JAVA");
		System.out.println(str5);
		
		//subString(index) index번지부터 마지막까지의 문자열
		String str6 = str5.substring(2);
		System.out.println(str6);
		//subString(index,endex) index번지부터 endex-1번지까지 문자열 추출
		String str7= str5.substring(2,str5.length()-1);
		//low 소문자로 , up 대문자로
		System.out.println(str5.toLowerCase());
		System.out.println(str5.toUpperCase());
		
		//trim() 첫글자 앞의 공백과 마지막 글자 뒤의 공백을 제거
		String str8 = "\n\n\n     abc \n\n\n";
		System.out.println(str.trim());
		
		//valueOf 기본형값을 문자열로 만듬
		String str9=String.valueOf(1);
		System.out.println(str9);
		
		//split(구분자) 구분자를 기준으로 문자열을 추출하여 배열로 반환
		String f ="바나나,사과,딸기";
		String[] fs =f.split(",");
		for(String ff:fs) {
			System.out.println(ff);
		}
	}

}
