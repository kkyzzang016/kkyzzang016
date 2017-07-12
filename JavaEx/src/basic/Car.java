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
		System.out.println("시동이 걸렸습니다.");
	}
	
	public void engineStop() {
		engine=false;
		System.out.println("시동이 꺼졌습니다.");
	}
	
	public void color(String a) {
		System.out.println("차의 색이 "+a+"로 정해졌습니다!");
		color = a;
	}
	public void selectCar() {
		System.out.println("원하는 차의 번호를 입력 해주세요! 1. 그렌져 | 2. 소나타 | 3. k5 | 4. 롤스로이스");
		Scanner sc = new Scanner(System.in);
		carNum = sc.nextInt();
		if(carNum==1) car = "그렌져";
		else if(carNum==2) car="소나타";
		else if(carNum==3) car="k5";
		else if(carNum==4) car="롤스로이스";
		else {
			System.out.println("잘못 입력하셨습니다.");
			selectCar();
		}
		
		System.out.println("차의 색을 정해주세요!");
	}
	
	public void out() {
		System.out.println("차의 정보는 "+color+", "+car+"입니다.");
	}
	public static void main(String[] args) {
		
		Car c = new Car();
		
		Scanner sc = new Scanner(System.in);
		
		c.selectCar();
		c.color(sc.nextLine());
		c.out();
		System.out.println("차 시동을 걸고 싶으시다면 y를 입력하세요!");
		if(sc.nextLine().equals("y")) c.engineStart();
		System.out.println("차 시동을 끄고 싶으시다면 n를 입력하세요!");
		if(sc.nextLine().equals("n")) c.engineStop();
	
		c.out();
		if(c.engine=true) System.out.println("차량 시동은 켜져있습니다.");
		else System.out.println("차량 시동은 꺼져있습니다.");
	}
}
