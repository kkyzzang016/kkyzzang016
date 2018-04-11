package myjava;

public class MyArray {

	public static void main(String[] args) {
		// 정수형 변수 100개 필요할 때
		// 배열을 선언, 생성, 할당, 참조하는 방법
		int list[];
		// int list[10];
		int[] list2;

		list = new int[10]; //생성 후 초기화된다. int라서 0이 들어간다.
		// list = new int[];
		list[0] = 100;
		// list[10] = 500;
		System.out.println(list[1]);
		System.out.println(list.length); //배열의 길이를 알 수 있다.
	}
}