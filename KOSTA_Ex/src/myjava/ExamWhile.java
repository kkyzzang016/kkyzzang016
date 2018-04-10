package myjava;

import java.util.Scanner;

public class ExamWhile {

	public static void main(String[] args) {
		/*
		 * 문자를 입력받아서 그 문자가 대문자이면 소문자로 출력하고
		 * 소문자이면 대문자로 출력한다.
		 * 단 문자가 아니면 프로그램을 종료한다.
		 * 문자이면 계속 수행
		 */

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("문자를 입력하세요");

			String str = sc.nextLine();
			if(str.length()!=1) {
				System.out.println("문자열 입니다. 프로그램을 종료합니다.");
				break;
			}

			char c = str.charAt(0);
			if(c>='a' && c<='z') {
				System.out.println(Character.toUpperCase(c));
			}
			else if(c>='A' && c<='Z') {
				System.out.println(Character.toLowerCase(c));
			}
			else {
				System.out.println("문자가 아닙니다. 프로그램을 종료합니다.");
				break;
			}
		}
	}
}
