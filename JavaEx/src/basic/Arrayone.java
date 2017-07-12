package basic;
import java.util.Scanner;


public class Arrayone {
	public static void main(String[] args) {
		
		/*
		 * 배열 
		 * 같은 자료형의 데이터를 여러개 저장하기 위한 메모리 공간을 말함
		 * 생성된 메모리공간에 index를 이용하여 각 기억장소를 구분함
		 * 배열크기는 length를 사용하여 구함
		 */
		
		int[]arr = new int[3];
		arr[0]=1; 
		arr[1]=2;
		arr[2]=3;
		System.out.println("arr[0] : "+arr[0]);
		System.out.println("arr[1] : "+arr[1]);
		System.out.println("arr[2] : "+arr[2]);
		
		int [][] arr2 = {{10,20},{30,40},{50,60}};
		
		for(int i=0; i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				System.out.print("arr[" + i + "][" + j + "]: "+ arr2[i][j]+"\t");
			}
			System.out.println();
		}
		
		for(int [] i : arr2) {
			for(int j : i) {
				System.out.println(i);
			}
		}
		
		/*int[][]bank = {{0,0}};
		Scanner sc = new Scanner(System.in);
		System.out.println("생성 할 계좌를 적어주세요!");
		bank[0][0] = sc.nextInt();
		System.out.println("입급하실 금액을 적어주세요!");
		bank[0][1] = sc.nextInt();
		
		System.out.println("현재 잔액은 : "+ bank[0][1]);
		System.out.println("처리 된계좌 : "+bank[0][0]);*/
	}
}