package myjava;

public class MyFor {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		/*
		 * 방정식의 해를 출력하시오. 10 = 2x+y; x,y는 정수이며 0<=x,y<=10
		 */

		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if (((2 * x) + y) == 10) {
					System.out.println("x가 " + x + "일 때, y가 " + y + "일 때 방정식이 성립합니다.");
				}
			}
		}
	}
}