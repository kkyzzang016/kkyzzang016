package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOEx4 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String data="";
		while(true) {
			System.out.print("문자열 입력 : ");
			try {
				data=br.readLine();
			} catch (Exception e) {
				System.out.println("Exception : "+e.getMessage());
			}
			if(data.equals("end")) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println("입력한 데이터는 : "+data+" 입니다.");
		}
	}
}