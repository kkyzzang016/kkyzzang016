package Api;

public class IntegerEx {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);  //args[0] =100 
		Integer b = new Integer(10);
		
		int c = b.intValue();
		int sum = a+c;
		System.out.println("��� 1 : "+sum);
		
		//*����ڽ� �����ڽ�
		int d = new Integer(100);
		Integer e = 200;
		int sum2 = d+e;
		Integer sum3 = d+e;
		
		System.out.println("��� 2 : "+sum2);
		System.out.println("��� 3 : "+sum3);
	}
}
