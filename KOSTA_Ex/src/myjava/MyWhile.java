package myjava;

public class MyWhile {

	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		/*
		 * while문은 정해진 범위가 아닐때 사용하면 좋다.
		 * 변수로 무엇을?
		 * 로직을 어떻게 짜면 좋을까?
		 * 1부터 2,3,4,..... 계속 누적할때
		 * 얼마까지 누적해야 100000을 초과할까
		 */

		while(sum<=100000) {

			count ++;
			sum += count;

		}
		System.out.println("10만까지의 누적수는 "+(count)+" 입니다.");
	}
}