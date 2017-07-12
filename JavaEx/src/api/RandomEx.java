package api;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		Random ran = new Random();
		for(int i=0;i<10;i++) {
			float a = ran.nextFloat();
			System.out.println("Float형 난수 : "+a);
			
			int b = ran.nextInt(3);
			System.out.println("Int형 난수1 : "+b);
			
			int c = (int)(Math.random()*3);
			System.out.println("Int형 난수2 : "+c);
			
			System.out.println();
			
		}
	}
}
