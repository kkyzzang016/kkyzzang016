package Basic;
public class Animal {

	String name;
	int age;
	
	public Animal() {
		this.name="��";
		this.age=30;
	}
	
	public Animal(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void bark() {
		System.out.println("���ƾ�");
	}
	
	public void info() {
		System.out.println("����� ������ "+name+" �Դϴ�.");
		System.out.println(name+"�� ���̴� "+age+"�� �Դϴ�.");
		System.out.println(age+name);
	}
	
	public static void main(String[] args) {
		Animal an = new Animal();
		Animal an1 = new Animal("��",25);
		
		an1.info();
		an1.bark();
		System.out.println();
		an.info();
		an.bark();
	}
}
