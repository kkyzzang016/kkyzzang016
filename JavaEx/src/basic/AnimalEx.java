package basic;
public class AnimalEx extends Animal{

	//�� �Ӽ�
	//�� ���
	String name = "";
	int ageA;
	public AnimalEx() {
		super.name = "����";
		super.age = 30;
	}
	public static void main(String[] args) {
		
		/*
		 * ��������)
		 * 	1)���� ȣ������ �̸��� ���� ���
		 * 	2) ������ ȣ������ ������ ����Ͻÿ�
		 */
		
		new AnimalEx().bark();
		new AnimalEx().info();
	}
}