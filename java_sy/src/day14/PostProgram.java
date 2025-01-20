package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostProgram {
	Scanner sc = new Scanner(System.in);
	private PostManager postManager = new PostManager();
	public void run() {
		int menu=0;
		List<Post> posts = new ArrayList<Post>();
		postManager = new PostManager(posts);
		do {
			printMenu();
			menu =sc.nextInt();
			removeBuffer();
			switch(menu) {
			case 0:System.out.println("종료합니다"); return;
			case 1:insertPost(); break;
			case 2:updatePost();break;
			case 3:delPost(); break;
			case 4:searchPost(); break;
			default:System.out.println("잘못된 입력");
			}
		}while(menu != 0);
		
		
	}
	private void updatePost() {
		System.out.print("몇번째 게시글을 수정 하겠습니까?");
		int num = sc.nextInt();
		if(!postManager.numCheck(num)) {
			System.out.println("잘못된 번호 입력");
			return;
		}
		Post post =setPost();
		post.setNum(num);
		postManager.updatePost(post);
	}
	private void viewPost() {
		postManager.postView();
	}
	private void removeBuffer() {
		sc.nextLine();
	}
	private void insertPost() {
		Post post = setPost();
		postManager.insertPost(post);
	}
	private Post setPost() {
		System.out.print("제목: ");
		String title = sc.nextLine();
		System.out.print("내용: ");
		String content = sc.nextLine();
		System.out.print("작성자: ");
		String writer = sc.nextLine();
		return new Post(title,content,writer);
	}
	public void printMenu() {
		System.out.println("==========================게시판=======================");
		viewPost();
		System.out.println("=====================================================");
		System.out.println("1.게시판 등록  2.게시판 수정  3.게시판 삭제 4.내용 보기 0.종료");
		System.out.print("선택: ");
	}
}
