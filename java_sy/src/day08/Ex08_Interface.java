package day08;

public class Ex08_Interface {

	public static void main(String[] args) {
		System.out.println(Program.num);
	}

}
interface Program{
	int num=10;
	void printMenu();
	void runMenu();
}
class StrudentProgram implements Program{

	@Override
	public void printMenu() {
		System.out.println("메뉴 출력");
		
	}

	@Override
	public void runMenu() {
		// TODO Auto-generated method stub
		
	}
	
}