package io;

import java.io.IOException;

public class IOEx3 {

	public static void main(String[] args) {
		//�迭�� �̿��� ���� ������� �Ͻÿ�.
		byte b [] = new byte[10];		//���� ���� �迭 ���� Ȯ��
		System.out.print("�Է� : ");
		char ch = 'a';
		
		try {
			System.in.read(b, 0, 10);
		} catch (IOException e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
		System.out.print("��� : ");
		System.out.write(b, 0, 10);
		System.out.println();
	}
}
