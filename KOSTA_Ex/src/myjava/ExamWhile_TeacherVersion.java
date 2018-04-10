package myjava;

import java.util.Scanner;

public class ExamWhile_TeacherVersion {

	public static void main(String[] args) {
		/*
		 * 문자를 입력받아서 그 문자가 대문자이면 소문자로 출력하고
		 * 소문자이면 대문자로 출력한다.
		 * 단 문자가 아니면 프로그램을 종료한다.
		 * 문자이면 계속 수행
		 */

		Scanner scan = new Scanner(System.in);
		System.out.println("문자를 입력바랍니다.");
		int input = scan.next().charAt(0);
		System.out.println((char)input);

		while((input>='A' && input <='Z') || (input>='a' && input <='z')) {
			if(input>='A' && input<='Z') {
				System.out.println((char)(input+('a'-'A')));
			}else {
				System.out.println((char)(input-('a'-'A')));
			}
			System.out.println("문자를 입력바랍니다.");
			input = scan.nextInt();
		}
	}
}
