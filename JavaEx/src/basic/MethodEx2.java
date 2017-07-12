package basic;
public class MethodEx2 {
	//문제1) 배열에 나열된 정수의 값만큼 구구단을 출력하시오
	
	//문제2) 각 출력한 구구단의 합을 구하고 배열로 반환하여 합을 출력하시오.

	public static void gugu(int[] a) {
		for(int i=1;i<=9;i++) {
			for(int temp:a) {
				System.out.print(temp+"*"+i+"="+temp*i+"\t");
			}
			System.out.println();
		}
	}
	
	public static int[] guguCalc(int[] a) {
		
		int b[] = new int[3];
		int x=0;
		int sum=0;
		
		for(int temp:a) {
		for(int i=1;i<=9;i++) {
			sum =temp*i;	
			b[x]+=sum;				
			}
			x++;
			sum=0;
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		
		int a[] = {2,6,8};
		int sum=0;
		gugu(a);
		System.out.println();
		
		System.out.print("각 단의 합 : ");
		for(int hi : guguCalc(a)) {
			System.out.print(hi+" ");
			sum+=hi;
		}
		System.out.println();
		System.out.println("배열의 합 : "+ sum);
	}
}
