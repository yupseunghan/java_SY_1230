package day09;

public class Ex14_Generic {

	public static void main(String[] args) {
		Array<String> a = new Array<>(5);
		a.set(0, "abc");
		a.set(1,"123");
		System.out.println(a.get(0));
		a.print();
		
		System.out.println("----------");
		Array<Integer> a1 = new Array<>(5);
		a1.set(0, 123);
		a1.set(1,321);
		System.out.println(a1.get(0));
		a1.print();
		
		System.out.println("----------");
		print(1);
		print("123");
		
	}
	public static <E> void print(E e) {
		if(e == null)
			return;
		System.out.println(e);
	}
}
class Array<E>{
	private E[] list;
	
	public void setList(E[] list) {
		this.list=list;
	}
	
	public E[] getList(){
		return list;
	}
	
	public Array(int size) {
		list=(E[]) new Object[size];
	}
	
	public E set(int index, E data) {
		if(index<0||index>=list.length)
			return null;
		E tmp = list[index];
		list[index] =data;
		return tmp;
	}
	public E get(int index) {
		if(index<0||index>=list.length)
			return null;
		return list[index];
	}
	public void print() {
		for(E tmp:list) {
			if(tmp != null)
				System.out.println(tmp);
		}
	}
}