package Basic;
public class ForContinueEx {
 public static void main(String[] args) {
	
	 int k=0;
	 for(int i=0;i<10;i++) {
		 System.out.println("반복 실행문");
		 k++;
		 if(k<4) {
			 continue;
		 }
		 System.out.println("반복 실행 제한");
	 }
	 
	 //5.0 향상 된 포문
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