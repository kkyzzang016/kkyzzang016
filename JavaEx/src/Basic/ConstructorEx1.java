package Basic;
public class ConstructorEx1 {

	int a;
	
	//�⺻ �����ڸ� ���� �ؾ� �� ���
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
		ConstructorEx1 ce2 = new ConstructorEx1(3,"��Ʈ��");
		ConstructorEx1 ce3 = new ConstructorEx1("A",20);
	}
}