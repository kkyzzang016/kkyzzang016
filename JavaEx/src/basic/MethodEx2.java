package basic;
public class MethodEx2 {
	//����1) �迭�� ������ ������ ����ŭ �������� ����Ͻÿ�
	
	//����2) �� ����� �������� ���� ���ϰ� �迭�� ��ȯ�Ͽ� ���� ����Ͻÿ�.

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
		
		System.out.print("�� ���� �� : ");
		for(int hi : guguCalc(a)) {
			System.out.print(hi+" ");
			sum+=hi;
		}
		System.out.println();
		System.out.println("�迭�� �� : "+ sum);
	}
}
