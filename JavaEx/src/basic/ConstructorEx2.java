package basic;
import java.util.Scanner;

public class ConstructorEx2 {

	Scanner sc = new Scanner(System.in);
	
	public ConstructorEx2() {
		this(50,"ȫ�浿");
		System.out.println("��˶�!!");
	}
	ConstructorEx2(int a){
		System.out.println("��˶�!! "+a);
	}
	public ConstructorEx2(int a, String s) {
		System.out.println("��˶�!! " +s);
	}
	
	public static void main(String[] args) {
		System.out.println("��˶� Test");
		new ConstructorEx2();
	}
}