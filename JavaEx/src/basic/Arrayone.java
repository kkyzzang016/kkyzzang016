package basic;
import java.util.Scanner;


public class Arrayone {
	public static void main(String[] args) {
		
		/*
		 * �迭 
		 * ���� �ڷ����� �����͸� ������ �����ϱ� ���� �޸� ������ ����
		 * ������ �޸𸮰����� index�� �̿��Ͽ� �� �����Ҹ� ������
		 * �迭ũ��� length�� ����Ͽ� ����
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
		System.out.println("���� �� ���¸� �����ּ���!");
		bank[0][0] = sc.nextInt();
		System.out.println("�Ա��Ͻ� �ݾ��� �����ּ���!");
		bank[0][1] = sc.nextInt();
		
		System.out.println("���� �ܾ��� : "+ bank[0][1]);
		System.out.println("ó�� �Ȱ��� : "+bank[0][0]);*/
	}
}