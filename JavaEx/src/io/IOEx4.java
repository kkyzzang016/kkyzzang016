package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOEx4 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String data="";
		while(true) {
			System.out.print("���ڿ� �Է� : ");
			try {
				data=br.readLine();
			} catch (Exception e) {
				System.out.println("Exception : "+e.getMessage());
			}
			if(data.equals("end")) {
				System.out.println("���α׷� ����");
				break;
			}
			System.out.println("�Է��� �����ʹ� : "+data+" �Դϴ�.");
		}
	}
}