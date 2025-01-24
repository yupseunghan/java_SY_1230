package day16;

import java.util.ArrayList;
import java.util.List;

public class PostManager {
	private List<Post> posts;
	public PostManager(List<Post> posts) {
		if(posts ==null)
			this.posts = new ArrayList<Post>();
		else
			this.posts = posts;
	}
	public PostManager() {
		posts = new ArrayList<Post>();
	}
	public void insertPost(Post post) {
		posts.add(post);
		System.out.println("게시글 추가");
	}
	public void postView() {
		if(posts==null||posts.size()==0) {
			System.out.println("등록된 게시글이 없습니다");
			return;
		}
		for(Post tmp : posts) {
			tmp.print();
		}
	}
	public boolean numCheck(int num) {
		boolean check =false;
		for(int i=0;i<posts.size();i++) {
			if(posts.get(i).getNum()==num)
				check=true;
		}
		return check;
	}
	public void updatePost(Post post) {
		int index = posts.indexOf(new Post(post.getNum()));//찾은 다음에 포스트 겟인덱스 로 인덱스 알면 점 업데이트
		if(index < 0) {
			System.out.println("게시글이 없습니다");
			return;
		}
		//posts.get(index).update(post);
	}
	public void delPost(Post post) {
		int index = posts.indexOf(new Post(post.getNum()));//찾은 다음에 포스트 겟인덱스 로 인덱스 알면 점 업데이트
		if(index < 0) {
			System.out.println("게시글이 없습니다");
			return;
		}
		posts.remove(index);
	}

}
