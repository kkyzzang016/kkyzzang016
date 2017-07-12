package basic;
import java.util.Scanner;

public class ConstructorEx2 {

	Scanner sc = new Scanner(System.in);
	
	public ConstructorEx2() {
		this(50,"È«±æµ¿");
		System.out.println("¹è¶Ë¶ì!!");
	}
	ConstructorEx2(int a){
		System.out.println("¹è¶Ë¶ì!! "+a);
	}
	public ConstructorEx2(int a, String s) {
		System.out.println("¹è¶Ë¶ì!! " +s);
	}
	
	public static void main(String[] args) {
		System.out.println("¹è¶Ë¶ì Test");
		new ConstructorEx2();
	}
}