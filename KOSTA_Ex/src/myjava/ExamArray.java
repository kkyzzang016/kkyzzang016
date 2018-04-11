package myjava;

public class ExamArray {

	public static void main(String[] args) {
		/*
		 * 크기가 6인 int배열을 선언하고 생성한다.
		 * 배열 각각에 1 ~ 55사이의 임의수를 할당한다.
		 * 배열 내부 값을 출력한다.
		 */
		int [] arr = new int[6];

		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*55)+1;
			System.out.print(arr[i]+" ");
		}
		// 자바배열은 동일한 타입, 크기변경불가
	}
}
