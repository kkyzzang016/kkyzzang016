package basic;
public class Rect extends Shape{

	protected int width, height;
	public Rect() {
		
	}
	public Rect(int w, int h) {
		width = w;
		height = h;
		x=getWidth();
		y=getHeight();
	}
	@Override
	public double area() {
		return width*height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setSize(int w, int h) {
		width=w;
		height=h;
	}
	
	public int getSize() {
		return x*y;
	}

	public double circumference() {
		return 2*(width+height);
	}
	
}
