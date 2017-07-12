package basic;
interface InterfaceA{
	int b=100;
	String method();
}

interface InterfaceB{
	int a=10;
	void setA();
}

abstract class abstractC{
	void setB(){
		System.out.println("B");
	}
}

public class InterfaceEx extends abstractC implements InterfaceA, InterfaceB{

	@Override
	public void setA() {
		System.out.println("setA method...");
		
	}

	@Override
	public String method() {
		return "Override method";
	}

	public static void main(String[] args) {
		InterfaceEx inter = new InterfaceEx();
		inter.setB();
		System.out.println("number : "+(b+a));
		System.out.println(inter.method());
		inter.setA();
	}
}
