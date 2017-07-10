package Basic;
import java.util.Arrays;

public class ArrayEx3 {
	public static void main(String[] args) {
		
		//배열의 max값 구하기
		int [] array = {1,5,3,8,2};
		//배열의 total, avg구하기
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
		System.out.println(array[4]);				 //답
		
		int a=0;
		for(int max : array) {
			if(a<max) a=max;
		}
		System.out.println(a);					 	 //답
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
	}
		System.out.println();		
		
		//2번
		int sum=0;
		
		for(int i=0;i<array2.length;i++) {
			for(int j=0;j<array2[i].length;j++) {
				sum +=array2[i][j];
			}
		}
		double avg=(double)sum/10;
		System.out.println("총합은 : "+sum);
		System.out.println("평균은 : "+ avg);
	}
}