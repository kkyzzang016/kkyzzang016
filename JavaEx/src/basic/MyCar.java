package basic;
public class MyCar {

	public static void main(String[] args) {
		
		CarEx e = new CarEx(4, 500, "¿¡Äí½º");
	
		System.out.println(e.getName());
	}
}
class CarEx{
	private int wheel;
	private int speed;
	private String name;
	
	public CarEx(int wheel, int speed, String name) {
		this.wheel=wheel;
		this.speed=speed;
		this.name=name;
	}
	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}