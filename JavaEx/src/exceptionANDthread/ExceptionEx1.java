package exceptionANDthread;

public class ExceptionEx1 {
	public static void main(String[] args) {
		
		try {
			int[] array = new int[3];
			array[0]=0;
			array[1]=10;
			array[2]=20;
			
			for(int i=0;i<array.length;i++) {
				System.out.println("array["+i+"] = "+array[i]);
			}
		
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
			
		}finally {
			System.out.println("finally ����!!!!");
		}
	}
}