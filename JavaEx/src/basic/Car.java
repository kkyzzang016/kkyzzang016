package basic;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Car {
	
	boolean engine=false;
	String color;
	String car;
	int carNum;
	
	public void engineStart() {
		engine=true;
		System.out.println("�õ��� �ɷȽ��ϴ�.");
	}
	
	public void engineStop() {
		engine=false;
		System.out.println("�õ��� �������ϴ�.");
	}
	
	public void color(String a) {
		System.out.println("���� ���� "+a+"�� ���������ϴ�!");
		color = a;
	}
	public void selectCar() {
		System.out.println("���ϴ� ���� ��ȣ�� �Է� ���ּ���! 1. �׷��� | 2. �ҳ�Ÿ | 3. k5 | 4. �ѽ����̽�");
		Scanner sc = new Scanner(System.in);
		carNum = sc.nextInt();
		if(carNum==1) car = "�׷���";
		else if(carNum==2) car="�ҳ�Ÿ";
		else if(carNum==3) car="k5";
		else if(carNum==4) car="�ѽ����̽�";
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			selectCar();
		}
		
		System.out.println("���� ���� �����ּ���!");
	}
	
	public void out() {
		System.out.println("���� ������ "+color+", "+car+"�Դϴ�.");
	}
	public static void main(String[] args) {
		
		Car c = new Car();
		
		Scanner sc = new Scanner(System.in);
		
		c.selectCar();
		c.color(sc.nextLine());
		c.out();
		System.out.println("�� �õ��� �ɰ� �����ôٸ� y�� �Է��ϼ���!");
		if(sc.nextLine().equals("y")) c.engineStart();
		System.out.println("�� �õ��� ���� �����ôٸ� n�� �Է��ϼ���!");
		if(sc.nextLine().equals("n")) c.engineStop();
	
		c.out();
		if(c.engine=true) System.out.println("���� �õ��� �����ֽ��ϴ�.");
		else System.out.println("���� �õ��� �����ֽ��ϴ�.");
	}
}
