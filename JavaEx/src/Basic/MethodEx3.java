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
			System.out.println("    1.�л���    |    2.�����Է�    |    3.��������Ʈ    |    4.�м�    |    5.����   ");
			System.out.println("==================================================");
			System.out.print("����>\t");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				//�ۼ���ġ
				System.out.print("�л� ���� �Է��Ͻÿ�!>   ");
				int stu = sc.nextInt();
				scores = new int[stu];
				System.out.println();
				
			}else if(selectNo == 2) {
				//�ۼ���ġ
				for(int i=0;i<scores.length;i++) {
					System.out.print((i+1)+"��° �л��� ������ �Է��Ͻÿ�!>  ");
					scores[i]=sc.nextInt();
				}
				System.out.println("�����Է��� ����Ǿ����ϴ�.\n");
				
			}else if(selectNo == 3) {
				//�ۼ���ġ
				System.out.print("�� �л����� ������ : \t");
				for(int i=0;i<scores.length;i++) {
					System.out.print((i+1)+"��° : "+scores[i]+"\t");
				}
				System.out.println();
				
			}else if(selectNo == 4) {
				//�ۼ���ġ
				int max=0;
				int sum=0;
				
				for(int i=0;i<scores.length;i++) {
					if(scores[i]>max) max=scores[i];
					sum+=scores[i];
				}
				double avg = (double)sum/scores.length;
				
				System.out.print("�ְ����� : "+max+"\t");
				
				System.out.print("���� : " + sum+"\t");
				System.out.println("��� : "+avg);
				System.out.println();
				
			}else if(selectNo == 5) {
				run = false;
			}else System.out.println("�߸� �Է� �ϼ̽��ϴ�.\n");
		}

		System.out.println("���α׷� ����");
	}
}