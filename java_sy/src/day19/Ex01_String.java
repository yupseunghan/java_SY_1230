package day19;

public class Ex01_String {

	public static void main(String[] args) {
		String str ="abcabaabbcabcbacbabababcabcacccac";
		String search="ab";
		/*int count = str.split(search,-1).length-1;
		System.out.println(count);*/
		String tmp =str;
		int index =-1,count=0;
		do {
			index=str.indexOf(search);
			if(index != -1) {
				count++;
				int pos=index+search.length();
				if(pos >=tmp.length()) {
					index=-1;
					continue;
				}
				tmp = tmp.substring(pos);
			}
		}while(index!=-1);
		System.out.println(str+"에 "+search+"가 "+count+"번 있습니다");
	}
}


