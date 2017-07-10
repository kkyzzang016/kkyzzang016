package Basic;
import java.util.Scanner;

class Student01{
	int score;
	String name;
	public Student01(String name, int scores) {
		this.name=name;
		this.score=score;
	}
}

public class Exercise09 {

	public Scanner scan;
	public Student01[] list;
	
	public Exercise09() {//������
		scan= new Scanner(System.in); 
	}
	
	public void addStudent() {
		for(int i=0; i<list.length;i++) {
			System.out.println("�л� �̸� �Է� : ");
			String name = inputStr();
			System.out.println("�л� ���� �Է� : ");
			int scores = inputNum();
			list[i] = new Student01(name,scores);
		}
	}
	
	public int inputNum() {
		return scan.nextInt();
	}
	
	public String inputStr() {
		return scan.next();
	}
	
	public void execute() {
		
		do {
		System.out.println("==================================================");
		System.out.println("    1.�л���    |    2.�����Է�    |    3.��������Ʈ    |    4.�м�    |    5.����   ");
		System.out.println("==================================================");
		System.out.print("����>\t");
		
		switch(inputNum()) {
		
		case 1:
			System.out.println("�л����� �Է��ϼ���.");
			int su = inputNum();
			list = new Student01[su];
			System.out.println(list.length + "���� �л����� �߰��� �ּ���");
			addStudent();
			break;
			
		case 2:
			Student01 st = null;
			System.out.println("�л� �̸��� �Է��ϼ��� : ");
			String name = inputStr();
			boolean checked = false;
			for(int i=0; i<list.length;i++) {
				st = list[i];
				if(st.name.equals(name)) {
					checked = true;
					break;
				}
			}
			if(checked) {
				System.out.println(name + "�� ������ �Է��ϼ��� : ");
				st.score = inputNum();
			}else System.out.println("������ �����ϴ�.");
			break;
			
		case 3:
			for(Student01 a : list) {
				System.out.println(a.score);
			}
			break;
		}
	}while(true);
		
	}
	public static void main(String[] args) {
		Exercise09 e = new Exercise09();
		e.execute();
	}
}
