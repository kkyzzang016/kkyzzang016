package api;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		Random ran = new Random();
		for(int i=0;i<10;i++) {
			float a = ran.nextFloat();
			System.out.println("Float�� ���� : "+a);
			
			int b = ran.nextInt(3);
			System.out.println("Int�� ����1 : "+b);
			
			int c = (int)(Math.random()*3);
			System.out.println("Int�� ����2 : "+c);
			
			System.out.println();
			
		}
	}
}
