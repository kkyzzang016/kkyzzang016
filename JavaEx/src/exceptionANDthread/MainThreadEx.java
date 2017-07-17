package exceptionANDthread;

public class MainThreadEx {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User1 u = new User1();
		u.setCalculator(cal);
		u.start();
		
		User2 u2 = new User2();
		u2.setCalculator(cal);
		u2.start();
	}
}
