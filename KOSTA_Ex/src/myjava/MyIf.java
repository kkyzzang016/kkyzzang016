package myjava;

import java.util.Calendar;

public class MyIf {
	public static void main(String[] args) {
		int count = 500;

		/*
		 * 오늘이 주중인지 주말인지를 체크하여 주중이면...
		 * 열심히 공부합시다라는 문자열을 출력하고
		 * 주말이면 쫌 쉽시다라는 문자열을 출력한다.
		 * 토, 일은 주말
		 */

		int today;
		today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

		if (today < 7 && today > 1) {
			System.out.println("열심히 공부합시다.");
		} else
			System.out.println("쫌 쉽시다.");
	}
}
