package Basic;
class ACD{
	
	public ACD() {
		System.out.println("Class ACD");
	}
	int c;
	String d;
	
	public void exe() {
		System.out.println("123");
	}
} 

public class InherEx extends ACD{
	
	/*
	 * 	InherEx : Class A
	 */
	int a;
	String b;
	public InherEx() {
		// super();
		System.out.println("Class A");
	}
	public static void main(String[] args) {
		
		InherEx sub = 	new InherEx();
		sub.a =10;
		System.out.println(sub.a);
		sub.c=50;
		
		
	}
}
