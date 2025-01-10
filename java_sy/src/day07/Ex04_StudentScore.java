package day07;

import java.util.Scanner;

import lombok.AllArgsConstructor;

public class Ex04_StudentScore {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		char menu;
		int count=0;
		Student[] std = new Student[10];
		std[count++] = new Student(1,1,11,"한승엽","수학",100); 
		do {
			menulist();
			menu = sc.next().charAt(0);
			
			switch(menu) {
			case '1' : count=insertStudent(std,count); break;
			case '2' : checkStudent(std,count); break;
			case '3' : updateStudent(std,count); break;
			case '4' : count=deleteStudent(std,count); break;
			case '5' : System.out.println("프로그램 종료합니다"); break;
			default: System.out.println("다시 선택 해");
			}
		}while(menu!='5');
	}
	
	private static int deleteStudent(Student[] std, int count) {
		System.out.println("------------------\n학생 정보 삭제 ");
		System.out.print("학년: ");
	    int gr = sc.nextInt();
	    System.out.print("반: ");
	    int cl = sc.nextInt();
	    System.out.print("번호: ");
	    int num = sc.nextInt();
	    System.out.print("과목: ");
	    sc.nextLine();
	    String sub = sc.nextLine();
	    int index = indexOf(std,count,gr,cl,num,sub);
	    if(index >=0) {
	    	for (int i = index; i < count - 1; i++) {
	            std[i] = std[i + 1]; // 한 칸씩 앞당기기
	        }
	    	return count-1;
	    }
	    else
	    	System.out.println("과목이 없거나 학생 정보가 없습니다");
	    
		return count;
	}

	private static void updateStudent(Student[] std,int count) {
		System.out.println("------------------\n성적 수정하기 ");
		System.out.print("학년: ");
	    int gr = sc.nextInt();
	    System.out.print("반: ");
	    int cl = sc.nextInt();
	    System.out.print("번호: ");
	    int num = sc.nextInt();
	    System.out.print("과목: ");
	    sc.nextLine();
	    String sub = sc.nextLine();
	    System.out.print("수정 할 성적: ");
	    int score = sc.nextInt();
	    
	    int index = indexOf(std,count,gr,cl,num,sub);
	    if(index >=0) {
	    	std[index].update(score); 
	    	System.out.println("학생 정보를 수정했습니다");
	    }else
	    	System.out.println("과목이 없거나 학생 정보가 없습니다");
	    	
	}
	
	private static int indexOf(Student[] std, int count, int gr, int cl, int num, String sub) {
		int index=-1;
		for(int i=0;i<count;i++) {
			if(std[i].find(gr, cl, num, sub)) {
				index=i;
				return index;
			}
		}
		return index;
	}
	
	private static void checkStudent(Student[] std, int count) {
		for(int i=0; i < count; i++)
			std[i].printAll();
		
	}
	
	private static int insertStudent(Student[]std, int count) {
		System.out.print("학년: ");
	    int gr = sc.nextInt();
	    System.out.print("반: ");
	    int cl = sc.nextInt();
	    System.out.print("번호: ");
	    int num = sc.nextInt();
	    sc.nextLine();  // 버퍼 비우기
	    System.out.print("이름: ");
	    String name = sc.nextLine();
	    System.out.print("과목: ");
	    String sub = sc.nextLine();
	    System.out.print("성적: ");
	    int score = sc.nextInt();
	     
	    int index=indexOf(std, count, gr, cl, num, sub);
	    if(index >= 0) 
	    	System.out.println("이미 등록된 학생입니다");
	    else {
	    	Student tmp =new Student(gr,cl,num,name,sub,score);
		    std[count++] = tmp;
	    }
	    return count;
	    
	}
	
	private static void menulist() {
		System.out.println("---------------------");
		System.out.println("메뉴\n1. 학생 성적 추가\n2. 학생 성적 조회\n3. 학생 성적 수정\n4. 학생 정보 삭제\n5. 프로그램 종료");
		System.out.print("메뉴 선택: ");
	}
	
}
@AllArgsConstructor
class Student{
	private String name, sub;
	private int score ,gr,cl,num;
	public Student(int gr,int cl,int num, String name, String sub,int score) {
		this.gr=gr;
		this.cl=cl;
		this.num=num;
		this.name=name;
		this.sub=sub;
		this.score=score;
	}
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	public boolean find(int gr,int cl,int num,String sub) {
		return this.gr==gr&&this.cl==cl&&this.num==num&&this.sub.equals(sub) ? true:false;
	}
	public void update(int score) {
		this.score=score;
	}
	public void printAll() {
		System.out.println(gr+"학년 "+cl+"반 "+num+"번 "+name+"의 "+sub+"점수: "+score);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getGr() {
		return gr;
	}
	public void setGr(int gr) {
		this.gr = gr;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	
}