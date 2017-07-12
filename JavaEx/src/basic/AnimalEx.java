package basic;
public class AnimalEx extends Animal{

	//곰 속성
	//곰 기능
	String name = "";
	int ageA;
	public AnimalEx() {
		super.name = "나비";
		super.age = 30;
	}
	public static void main(String[] args) {
		
		/*
		 * 연습문제)
		 * 	1)동물 호랑이의 이름과 나이 출력
		 * 	2) 생성한 호랑이의 울음을 출력하시오
		 */
		
		new AnimalEx().bark();
		new AnimalEx().info();
	}
}