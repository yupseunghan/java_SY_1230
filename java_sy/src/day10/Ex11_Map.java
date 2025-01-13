package day10;

import java.util.HashMap;

public class Ex11_Map {

	public static void main(String[] args) {
		/* Map 인터페이스
		 * 	-Key,Value 값을 관리
		 * 	-Key:중복x
		 * 	-Value:중복o*/
		HashMap<String,String> map= new HashMap<>();
		/* put(k,v) : k와 v의 값을 각각 key와 value에 추가하여 저장
		 * k가 중복된 경우 v로 덮어쓰기 함*/
		map.put("abc123", "285600ju!");
		map.put("abc1233", "285600ju!");
		map.put("abc123", "sky6400!");
		System.out.println(map);
		/* get(k)
		 * 	-key값 중에서 k와 일치하는 value를 변환
		 * 	-없으면 null을 반환*/
		System.out.println(map.get("abc1234"));
		System.out.println(map.get("abc123"));
		
		/* isEmpty()
		 * 	-map이 비었는지 반환
		 * containsKey(k)
		 * 	-key값 중에서 k와 일치하는 값이 있는지를 반환
		 * containsValue(v)
		 * 	-value값 중에서 v와 일치하는 값이 있는지를 반환*/
		System.out.println(map.isEmpty());
		System.out.println(map.containsKey("abc"));
		System.out.println(map.containsKey("abc123"));
		System.out.println(map.containsValue("285600ju!"));
		System.out.println(map.containsValue("285600asd"));
		
		/* remove(k)
		 * 	-key값 중에 k와 일치하는 값이 있으면 삭제 훟 value를 반환
		 * remove(k,v)
		 * 	-key값 중에서 k와 일치하고, value값 중에 v와 일치하는 값이 있으면 삭제 후 삭제 여부 반환*/
		System.out.println("삭제전: "+map);
		System.out.println(map.remove("abc123"));
		System.out.println("삭제후: "+map);
		System.out.println(map.remove("abc1233","285600ju!"));
		System.out.println("삭제후: "+map);
	}

}
