package Basic;
public class ConstructorEx1 {

	int a;
	
	//기본 생성자를 정의 해야 할 경우
	ConstructorEx1() {
		a=50;
		System.out.println("Constructor 1");
	}
	//overload
	ConstructorEx1(int a){
		System.out.println("Constructor 2 , a = "+this.a);
		System.out.println("Constructor 2 , a = "+a);
	}
	//overload
	ConstructorEx1(int a, String s){
		System.out.println("Constructor 3");
	}
	//overload
	ConstructorEx1(String a, int s){
		System.out.println("Constructor 4");
	}
	
	public static void main(String[] args) {
		new ConstructorEx1();
		
		ConstructorEx1 ce1 = new ConstructorEx1(5);
		ConstructorEx1 ce2 = new ConstructorEx1(3,"스트링");
		ConstructorEx1 ce3 = new ConstructorEx1("A",20);
	}
}