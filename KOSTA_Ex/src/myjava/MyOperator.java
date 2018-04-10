package myjava;

public class MyOperator {
	public static void main(String[] args) {

		int count = 500 + 500;
		System.out.println(500 * 5);
		System.out.println(7 / 4);
		System.out.println(1 == 1.0);

		// || &&

		int amount = 500;
		if (amount > 500 && amount++ == 501) {

		}

		String str = null;
		print(str);

		/*
		 * if (str != null && str.length() > 0) { 실제 이런식으로 코딩 많이함
		 *
		 * }
		 */

	}

	private static void print(String str) {
		if (str != null && str.length() > 0) {

		}
	}
}