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
		System.out.print("�л� ���� �Է��Ͻÿ�!>   ");
		int stu = sc.nextInt();
		scores = new int[stu];
		System.out.println();
		menu();
	}
	
	public void jumsu() {
		for(int i=0;i<scores.length;i++) {
			System.out.print((i+1)+"��° �л��� ������ �Է��Ͻÿ�!>  ");
			scores[i]=sc.nextInt();
		}
		System.out.println("�����Է��� ����Ǿ����ϴ�.\n");
		menu();
	}
	
	public void out() {
		System.out.print("�� �л����� ������ : \t");
		for(int i=0;i<scores.length;i++) {
			System.out.print((i+1)+"��° : "+scores[i]+"\t");
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
		
		System.out.print("�ְ����� : "+max+"\t");
		
		System.out.print("���� : " + sum+"\t");
		System.out.println("��� : "+avg);
		System.out.println();
		menu();
	}
	
	public void stop() {
		run = false;
		System.out.println("���α׷� ����");
	}
	
	public void menu() {
		System.out.println("==================================================");
		System.out.println("    1.�л���    |    2.�����Է�    |    3.��������Ʈ    |    4.�м�    |    5.����   ");
		System.out.println("==================================================");
		System.out.print("����>\t");
		
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
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.\n");
				menu();
				break;
		}
		}
	}
}
