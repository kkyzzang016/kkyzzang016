package myjava;

import java.util.Scanner;

public class ExamMethod {

	/*
	 * 사용자로부터 숫자를 입력받아서 그 숫자에 해당하는 별표를 아래와 같이 출력한다. 5를 입력받으면 * ** *** **** *****
	 * 그런데, 메소드 실습이라서 0 또는 음수가 입력되면 프로그램 종료, 반복해야 한다. 사용자로부터 숫자를 입력받아서 그 숫자를 리턴하는
	 * 메소드 숫자를 전달받아서 별표를 출력하는 메소드
	 *
	 */
	Scanner sc = new Scanner(System.in);

	public int inputNum() {
		System.out.println("원하시는 숫자를 입력하세요!!");
		int inputNum = sc.nextInt();

		return inputNum;
	}

	public void outputStar(int inputNum) {
		for (int i = 0; i < inputNum; i++) {
			for (int j = 0; j < inputNum; j++) {

				if (i >= j)
					System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		ExamMethod exam = new ExamMethod();
		int inputNum;

		while (true) {
			inputNum = exam.inputNum();
			if(inputNum<1) {
				System.out.println("0 또는 음수입니다. 프로그램을 종료합니다.");
				break;
			}
			exam.outputStar(inputNum);

		}
	}
}
