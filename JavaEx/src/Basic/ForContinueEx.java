package Basic;
public class ForContinueEx {
 public static void main(String[] args) {
	
	 int k=0;
	 for(int i=0;i<10;i++) {
		 System.out.println("�ݺ� ���๮");
		 k++;
		 if(k<4) {
			 continue;
		 }
		 System.out.println("�ݺ� ���� ����");
	 }
	 
	 //5.0 ��� �� ����
	 int [] arr = new int[] {1,2,3};
	 for(int a : arr) {
		System.out.print(a+"\t"); 
	 	}
	 System.out.println();
	 
	 for(String a : args) {
		 System.out.print(a+"\t");
	 }
	}
}