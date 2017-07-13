package generic;

public class BoundedTypeParameterEx {
	
	public static void main(String[] args) {
		int result1 = Util.compare(10, 20); //Double.compare(i ,j) : i가 크면 1, j가 크면 -1, 같으면 0 반환
		System.out.println(result1);
		int result2 = Util.compare(4.5, 3);
		System.out.println(result2);
		int result3 = Util.compare(2, 2);
		System.out.println(result3);
	}
}
