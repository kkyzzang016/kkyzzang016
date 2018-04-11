package myjava;

public class MyMethod {
	public static void main(String[] args) {
		greet(3); // ☆메소드를 호출☆, Call
		greet(5);
		greet(7);
	}

	/*
	☆메소드를 정의한 것☆
    문들의 집합이다. (선언문, 제어문, 할당문)
	반복구간을 메서드로 정의하고 필요한 곳에서 호출한다.
	리턴과 매개변수를 가질 수 있다.
	*/

	//Define
	private static void greet(int count) {
		for(int i=0;i<count;i++) {
			System.out.println("Hello");
		}
	}
}

abstract class MyClass{
	//Declare
	abstract int print(); // 추상메소드, ☆메소드 선언☆
}

