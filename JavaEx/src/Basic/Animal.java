package Basic;
public class Animal {

	String name;
	int age;
	
	public Animal() {
		this.name="곰";
		this.age=30;
	}
	
	public Animal(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void bark() {
		System.out.println("우어아엉");
	}
	
	public void info() {
		System.out.println("저장된 동물은 "+name+" 입니다.");
		System.out.println(name+"의 나이는 "+age+"살 입니다.");
		System.out.println(age+name);
	}
	
	public static void main(String[] args) {
		Animal an = new Animal();
		Animal an1 = new Animal("곰",25);
		
		an1.info();
		an1.bark();
		System.out.println();
		an.info();
		an.bark();
	}
}
