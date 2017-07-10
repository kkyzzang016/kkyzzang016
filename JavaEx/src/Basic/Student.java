package Basic;
import java.util.Scanner;

public class Student {

	
	public static void main(String[] args) {
		
		StudentMethod st = new StudentMethod();
		st.menu();
	}
}

class StudentMethod{
	boolean run = true;
	int studentNum=0;
	int [] scores = null;
	Scanner sc = new Scanner(System.in);
	
	public void su() {
		System.out.print("학생 수를 입력하시오!>   ");
		int stu = sc.nextInt();
		scores = new int[stu];
		System.out.println();
		menu();
	}
	
	public void jumsu() {
		for(int i=0;i<scores.length;i++) {
			System.out.print((i+1)+"번째 학생의 점수를 입력하시오!>  ");
			scores[i]=sc.nextInt();
		}
		System.out.println("성적입력이 종료되었습니다.\n");
		menu();
	}
	
	public void out() {
		System.out.print("각 학생들의 점수는 : \t");
		for(int i=0;i<scores.length;i++) {
			System.out.print((i+1)+"번째 : "+scores[i]+"\t");
		}
		System.out.println();
		menu();
	}
	
	public void calc() {
		int max=0;
		int sum=0;
		
		for(int i=0;i<scores.length;i++) {
			if(scores[i]>max) max=scores[i];
			sum+=scores[i];
		}
		double avg = (double)sum/scores.length;
		
		System.out.print("최고점수 : "+max+"\t");
		
		System.out.print("총점 : " + sum+"\t");
		System.out.println("평균 : "+avg);
		System.out.println();
		menu();
	}
	
	public void stop() {
		run = false;
		System.out.println("프로그램 종료");
	}
	
	public void menu() {
		System.out.println("==================================================");
		System.out.println("    1.학생수    |    2.점수입력    |    3.점수리스트    |    4.분석    |    5.종료   ");
		System.out.println("==================================================");
		System.out.print("선택>\t");
		
		while(run) {
		int selectNo = sc.nextInt();
		switch(selectNo) {
		case 1:
			su();
			break;
			
		case 2:
			jumsu();
			break;
			
		case 3:
			out();
			break;
			
		case 4:
			calc();
			break;
			
		case 5:
			stop();
			break;
			
			default : 
				System.out.println("잘못 입력 하셨습니다.\n");
				menu();
				break;
		}
		}
	}
}
