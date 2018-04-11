package myjava;

public class MyVariableScope {

	public static void main(String[] args) {

	}
}

//클래스의 구성요소?
class MySample {

	int count; // 인스턴스 변수
	static int amount; // 클래스 변수
	//print();

	// 메소드를 정의
	void print() {

		int mount; // 로컬변수
	}

	void write() {
		count = 500;
		for (int i = 0; i < 100; i++) { // 임시변수

		}
	}
}