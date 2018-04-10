package myjava;

public class MySwitch {
	public static void main(String[] args) {
		int count = 50;

		switch (count) {
		case 50:
			System.out.println("50");
			break;

		case 500:
			System.out.println("500");
			break;

		default :
			System.out.println("default");
			break;
		}
		/*
		 * 1~100 사이의 임의의 숫자를 만들어서 그 숫자의 학점을 출력함
		 */

		int jumsu = (int)(Math.random()*100)+1;

		switch(jumsu/10) {
		case 10:
		case 9:
			System.out.println(jumsu+"입니다. A학점");
			break;

		case 8:
			System.out.println(jumsu+"입니다. B학점");
			break;

		case 7:
			System.out.println(jumsu+"입니다. C학점");
			break;

		case 6:
			System.out.println(jumsu+"입니다. D학점");
			break;

		default :
			System.out.println(jumsu+"입니다. F학점");
		}
	}
}
