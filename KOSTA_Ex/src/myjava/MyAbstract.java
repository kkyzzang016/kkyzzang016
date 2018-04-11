package myjava;

public class MyAbstract {
	public static void main(String[] args) {
		MyCircle circle = new MyCircle();
	}
}
abstract class MyShape{
	int x,y;
	abstract double getArea();
}

class MyCircle extends MyShape{
	int radius;
	double getArea() {
		return 0;
	}
}

class MyRectangle extends MyShape{
	int width, height;
	double getArea() {
		return 0;
	}
}