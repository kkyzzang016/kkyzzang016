package basic;
public class InherEx2	extends SuperClass {

	int age=10;
	String name1;
	
	public void method() {
		System.out.println("SubClass Method");
	}
	public static void main(String[] args) {
		InherEx2 ih = new InherEx2();
		
		SuperClass sc = ih;
	}
}

class SuperClass{
	int age=20;
	String name1="";
}
