package day20;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private String id,pw,authority;
	
	
	

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.authority="사용자";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, pw);
	}	
}
