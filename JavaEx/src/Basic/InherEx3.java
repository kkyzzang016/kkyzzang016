package Basic;
class C{
	public C() {
		System.out.println("持失切 C");
	}
	int num=10;
	String msg="msg...";
	public void method() {
		System.out.println("五社球 "+num);
	}
	public void method_C() {
		System.out.println("五社球_C "+msg);
	}
}
class B extends C{
	public B() {
		super();
		System.out.println("持失切 B");
	}
	int num=50;
	
	public void method() {
		super.method_C();
		this.method_C();
		System.out.println("五社球 "+num);
	}
	public void method_B() {
		System.out.println("五社球_B "+msg);
	}
}

class A extends B{
	public A() {
		//super().super();
		System.out.println("持失切 A");
	}
	public void method() {
		//System.out.println("五社球 "+super.super.method());
	}
	public void method_A() {
		System.out.println("五社球_A "+msg);
	}
}

public class InherEx3 {

	public static void main(String[] args) {
		A a =new A();
		B b = a;
		C c= b;
		
		a.method();
		a.method_A();
		a.method_B();
		a.method_C();
		System.out.println(a.num);
	}
}














