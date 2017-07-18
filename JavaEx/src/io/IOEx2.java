package io;

import java.io.IOException;

public class IOEx2 {

	public static void main(String[] args) {
		int b=0, count=0;
		try {
			b=System.in.read();
			while(b != -1 ) {								//       -1 == Ctrl + z 키값 ( Ctrl + z 누르면 프로그램 종료 )
				System.out.print((char)b);
				count++;
				b=System.in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n byte InputStream Test... "+"total byte : "+count);
	}
}
