package Basic;
import java.util.Arrays;

public class ArrayEx3 {
	public static void main(String[] args) {
		
		//�迭�� max�� ���ϱ�
		int [] array = {1,5,3,8,2};
		//�迭�� total, avg���ϱ�
		int[][] array2 = {{95,86},{83,92,96},{78,83,93,87,88}};
		
		int temp; 
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<i;j++) {
			if(array[j]>array[i]) {
				temp = array[j];
				array[j] = array[i];
				array[i]=temp;
			}
		}
	}
		System.out.println(array[4]);				 //��
		
		int a=0;
		for(int max : array) {
			if(a<max) a=max;
		}
		System.out.println(a);					 	 //��
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
	}
		System.out.println();		
		
		//2��
		int sum=0;
		
		for(int i=0;i<array2.length;i++) {
			for(int j=0;j<array2[i].length;j++) {
				sum +=array2[i][j];
			}
		}
		double avg=(double)sum/10;
		System.out.println("������ : "+sum);
		System.out.println("����� : "+ avg);
	}
}