package myjava;

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog = new Dog(4);
		Chicken chicken = new Chicken(3);
		CheatableChicken cheatableChicken = new CheatableChicken(10);

		System.out.println("1 시간 후");
		dog.run(1);
		chicken.run(1);

		System.out.println("개의 이동거리="+dog.getDistance());
		System.out.println("닭의 이동거리="+chicken.getDistance());
	}
}

class CheatableChicken extends Animal implements Cheatable{

	CheatableChicken(int speed) {
		super(speed);

	}

	void run(int hours) {
		super.distance = super.speed * hours;
	}

	public void fly() {
		super.speed*=2;
	}
}
class Dog extends Animal{

	Dog(int speed) {
		super(speed);
	}

	void run(int hours) {
		distance = speed * hours;
	}
}
class Chicken extends Animal{

	Chicken(int speed) {
		super(speed);
	}

	void run(int hours) {
		super.distance = super.speed * hours;
	}

}