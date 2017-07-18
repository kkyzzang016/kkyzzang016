package io;

import java.io.IOException;

/*
*
* ���
	- ��Ʈ�� : �Ϲ������� ������, ��Ŷ ���� �Ϸ��� ���Ӽ��� ���� �帧�� �ǹ��Ѵ�. (�帣�� ������ - ���� �帧)
	
	- ��.��� ��Ʈ��(IO) : �����͸� �а� ���� ������ ���α׷��� ������ �𵨸� �� ���� ��
	
	- ���� : �����͸� �ӽ������� ��Ƶδ� ����
 
* �ڹ��� ����� ��Ʈ�� ����
	- �� �������� �帧
	- ���۸� ���� �� �ִ�.
   - FIFO(���Լ���)�� ����
   - ����(Character Stream), ����Ʈ(byte Stream) �� �з���
   
* ����(Character Stream) ���� �ֻ��� ��Ʈ��
	- Reader Class
		�Է� ��Ʈ�� : ���� �����͸� �о� ���̴� ��Ʈ��
	- Writer Class
		��� ��Ʈ�� : ���� �����͸� ����ϱ� ���� ��Ʈ��
		
* ����Ʈ(byte Stream) ����Ʈ �ֻ��� ��Ʈ��
	- InputStream Class
		�Է� ��Ʈ�� : ����Ʈ �����͸� �о� ���̴� ��Ʈ��
			(�Է� �ֻ��� ��Ʈ��)
	- OutputStream Class
		
*/
public class IOEx {
	
	public static void main(String[] args) {
		System.out.println("�Է� : ");//1�ڸ� �� ���
		char ch = 'a';
		try {
			ch = (char)System.in.read();
		} catch (IOException e) {
			System.out.println("Exception : "+e.getMessage());
		}
		System.out.println("��� : "+ch);
	}
}











