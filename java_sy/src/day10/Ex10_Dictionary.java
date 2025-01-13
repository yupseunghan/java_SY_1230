package day10;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Ex10_Dictionary {
	/*--------------
	 * 1.단어 등록
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.단어 검색
	 * 5.종료
	 * 메뉴선택: 1
	 * 단어:apple
	 * 의미: 사과, 회사명
	 * 단어가 등록됐습니다
	 * ------------
	 * 1.단어 등록
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.단어 검색
	 * 5.종료
	 * 메뉴선택: 1
	 * 단어: apple
	 * 의미: apple
	 * 이미 등록된 단어입니다
	 * ------------
	 * 1.단어 등록
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.단어 검색
	 * 5.종료
	 * 메뉴선택: 2
	 * 단어: apple
	 * 의미: 사과, 회사명(애플)
	 * 단어가 수정 됐습니다
	 * ------------
	 * 1.단어 등록
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.단어 검색
	 * 5.종료
	 * 메뉴선택: 4
	 * 단어: a
	 * apple:사과,회사명(애플)
	 * ------------
	 * 1.단어 등록
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.단어 검색
	 * 5.종료
	 * 메뉴선택: 3
	 * 단어: apple
	 * 단어가 삭제됐습니다
	 * ------------
	 * 1.단어 등록
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.단어 검색
	 * 5.종료
	 * 메뉴선택: 5
	 * 종료합니다
	 *
	 * */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Word> list = new ArrayList<>();
		char menu;
		do {
			menulist();
			menu=sc.next().charAt(0);
			switch(menu) {
			case '1':wordUp(list);break;
			case '2':wordUpdate(list);break;
			case '3':wordDel(list);break;
			case '4':wordCheck(list);break;
			case '5':System.out.println("종료합니다");return;
			default:System.out.println("잘못된 입력");
			}
		}while(menu != 5);
	}
	private static void wordDel(ArrayList<Word> list) {
		System.out.print("단어: ");
		sc.nextLine();
		boolean found = false;
		String myWord = sc.nextLine();
		for(Word word:list) {
			if(word.getName().equals(myWord)) {
				list.remove(word);
				System.out.println("단어를 삭제했습니다");
				found=true;
				return;
			}
		}
		if(!found)
			System.out.println("등록된 단어가 없습니다");
	}
	private static void wordUpdate(ArrayList<Word> list) {
		System.out.print("단어: ");
		sc.nextLine();
		boolean found = false;
		String myWord = sc.nextLine();
		for(Word word:list) {
			if(word.getName().equals(myWord)) {
				System.out.print("의미: ");
				word.setMean(sc.nextLine());
				System.out.println("단어가 수정됐습니다");
				found=true;
				return;
			}
		}
		if(!found)
			System.out.println("등록된 단어가 없습니다");
	}
	private static void wordCheck(ArrayList<Word> list) {
		System.out.print("단어: ");
		sc.nextLine();
		String myWord = sc.nextLine();
		boolean found = false;
		for(Word word:list) {
			if(word.getName().contains(myWord)) {
				System.out.println(word.getName()+": "+word.getMean());
				found=true;
			}
		}
		if(!found)
			System.out.println("해당 단어를 찾을 수 없습니다");
	}
	private static void wordUp(ArrayList<Word> list) {
		System.out.println("단어: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("의미: ");
		String mean = sc.nextLine();
		for(Word word:list) {
			if(word.getName().equals(name)) {
				System.out.println("이미 등록된 단어입니다");
				return;
			}
		}
		list.add(new Word(name,mean));
	}
	private static void menulist() {
		System.out.println("-----------\n1.단어 등록\n2.단어 수정\n3.단어 삭제\n4.단어 검색\n5.종료");
		System.out.print("메뉴선택: ");
	}
}
@Data
@AllArgsConstructor
@Getter
@Setter
class Word{
	private String name,mean;
}