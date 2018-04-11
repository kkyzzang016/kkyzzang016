package myjava;

import java.util.Stack;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass2 my; // 변수, 로컬변수, MyClass타입이다. => MyClass타입의 로컬변수
		// my라는 이름으로 할당받은 메모리공간엔 객체의 주소만이 저장가능하다.
		int count;
		my = new MyClass2();
		my.count = 500;
		System.out.println(my.count);
		MyClass2 my2=my;
		my2.count=100;
		System.out.println(my2.count);
		System.out.println(my.count);
	}
}

class MyClass2 {
	int count;
}
