package generic;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListEx {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("홍길동", "자바칩", "감자바");
		for(String name : list1) System.out.println(name);
		
		System.out.println();
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2) System.out.println(value);
	}
	
}
