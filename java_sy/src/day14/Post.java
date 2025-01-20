package day14;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;


@Data
public class Post {
	private static int count;
	private int num,view;
	private Date date;
	private String title,content,writer;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	public Post(String title, String content, String writer) {
		num = ++count;
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
	}
	public void print() {
		System.out.println(num+". 제목:"+title+" content"+" 작성자:"+writer+" 작성일:"+getDateStr()
		+" 조회수: "+view);
	}

	private String getDateStr() {
		if(date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
}
