package myjava;

public class CarTest {

	public static void main(String[] args) {
		Car hudson = new Car();
		Car carrera = new Car();
		Car mater = new Car();
		Car mcQueen = new Car();

		hudson.setName("hudson");
		carrera.setName("carrera");
		mater.setName("mater");
		mcQueen.setName("mcQueen");

		hudson.setSpeed(300);
		carrera.setSpeed(200);
		mater.setSpeed(80);
		mcQueen.setSpeed(300);

		System.out.println("\t*** 차량 정보 ***");
		System.out.println("차량이름 : "+hudson.getName()+",\t차량속도 : "+hudson.getSpeed());
		System.out.println("차량이름 : "+carrera.getName()+",\t차량속도 : "+carrera.getSpeed());
		System.out.println("차량이름 : "+mater.getName()+",\t차량속도 : "+mater.getSpeed());
		System.out.println("차량이름 : "+mcQueen.getName()+",\t차량속도 : "+mcQueen.getSpeed());
	}
}

class Car{

	private String name;
	private int speed;

	public Car() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}