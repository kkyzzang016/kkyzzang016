package myjava;

public class PersonTest {

	public static void main(String[] args) {

		Person person1 = new Person();
		Person person2 = new Person(13, "철수");

		person1.selfIntroduce();
		person2.selfIntroduce();
		System.out.println(Person.numberOfPerson);
	}

}
class Person {

	static int numberOfPerson;

	private int age;
	private String name;

	public Person() {
		this.age = 12;
		this.name = "Anonymous";
		numberOfPerson++;
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}

	void selfIntroduce() {

		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살 입니다.");
	}

	int getPopulation() {

		return numberOfPerson;
	}
}