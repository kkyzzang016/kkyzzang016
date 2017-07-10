package Basic;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class MethodEx3 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum=0;
		int [] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("==================================================");
			System.out.println("    1.학생수    |    2.점수입력    |    3.점수리스트    |    4.분석    |    5.종료   ");
			System.out.println("==================================================");
			System.out.print("선택>\t");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				//작성위치
				System.out.print("학생 수를 입력하시오!>   ");
				int stu = sc.nextInt();
				scores = new int[stu];
				System.out.println();
				
			}else if(selectNo == 2) {
				//작성위치
				for(int i=0;i<scores.length;i++) {
					System.out.print((i+1)+"번째 학생의 점수를 입력하시오!>  ");
					scores[i]=sc.nextInt();
				}
				System.out.println("성적입력이 종료되었습니다.\n");
				
			}else if(selectNo == 3) {
				//작성위치
				System.out.print("각 학생들의 점수는 : \t");
				for(int i=0;i<scores.length;i++) {
					System.out.print((i+1)+"번째 : "+scores[i]+"\t");
				}
				System.out.println();
				
			}else if(selectNo == 4) {
				//작성위치
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
				
			}else if(selectNo == 5) {
				run = false;
			}else System.out.println("잘못 입력 하셨습니다.\n");
		}

		System.out.println("프로그램 종료");
	}
}