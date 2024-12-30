package day01;

public class Ex08_VariableTest {

	public static void main(String[] args) {
		double literature=77.8, English=63.9, math=96.2;
		double average =(literature+English+math)/300 *100;
		char res='B';
		System.out.println("문학 점수:"+literature+" 영어 점수:"+English+" 수학 점수:"+math);
		System.out.printf("당신의 성적 평균: %.2f \n",average);
		System.out.println("학점:"+res);
	}

}
