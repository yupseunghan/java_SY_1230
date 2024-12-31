package day02;

public class Ex19_ForMulrtipleTable {

	public static void main(String[] args) {
		int n=2;
		for(int i=1;i<10;i++) {
			
			System.out.println("2 * "+i+" = "+n*i);
		}
		System.out.println("---------------");
		for(int i=2;i<=2;i++) {
			for(int j=1;j<=9;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}

}
