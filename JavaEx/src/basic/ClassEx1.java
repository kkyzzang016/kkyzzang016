package basic;
public class ClassEx1 {
	
	public String name;
	public int age;
	
	public void method1() {
		System.out.println("method1");
	}
	
	public String method2() {
		return "method2";
	}
	
	public static void main(String[] args) {
		ClassEx1 ce = new ClassEx1();
		System.out.println("name = "+ce.name);
		System.out.println("age = "+ce.age);
		
		ce.method1();
		String result = ce.method2();
		System.out.println(result);
	}
}
