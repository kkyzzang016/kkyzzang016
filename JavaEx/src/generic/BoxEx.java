package generic;

public class BoxEx {

	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.set("Hello");
		String str = box1.get(); //자동 언박싱
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(6);
		int value = box2.get(); //자동 언박싱
		
		System.out.println(str);
		System.out.println(value);
		
/*		비제너릭 타입 예제
		Box box = new Box();
		box.set("홍길동");
		String name = (String)box.get();
//		String name = box.get(); 비제너릭 타입을 이용하면 형변환 필수
		
		box.set(new Apple());
		Apple apple = (Apple)box.get();
//		Apple apple = box.get(); 비제너릭 타입을 이용하면 형변환 필수
		
		System.out.println(name);
		System.out.println(apple);
		*/
	}
}
