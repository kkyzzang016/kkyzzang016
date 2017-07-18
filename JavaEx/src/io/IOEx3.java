package io;

import java.io.IOException;

public class IOEx3 {

	public static void main(String[] args) {
		//배열을 이용한 문자 입출력을 하시오.
		byte b [] = new byte[10];		//문자 담을 배열 공간 확보
		System.out.print("입력 : ");
		char ch = 'a';
		
		try {
			System.in.read(b, 0, 10);
		} catch (IOException e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
		System.out.print("출력 : ");
		System.out.write(b, 0, 10);
		System.out.println();
	}
}
