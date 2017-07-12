package basic;
public class ShapeUser {

	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);
		shape[1] = new Circle(7);
		shape[2] = new Rect(9,5);
		
		Circle c = (Circle)shape[0];
		Rect r = (Rect)shape[2];
		
		System.out.println("shape[0]'s area = "+c.area()+c.getRadius());
		System.out.println("shape[1]'s area = "+shape[1].area());
		System.out.println("shape[2]'s area = "+shape[2].area());
	}
}
