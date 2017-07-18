package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOEx5 {

	public static void main(String[] args) throws IOException{
		FileReader reader = new FileReader(new File("C:/Users/odae/Desktop/Git/kkyzzang016/JavaEx/src/io/IOEx5_sample.txt"));
		
		//�迭�� ����Ͽ� ������ ���� �о� ����Ͻÿ�
		
		/* 1��
		char ch[] = new char[100];			//�迭�� ����Ͽ� 100���� ����Ȯ��
		reader.read(ch, 0, 100);				//100�� ������ �о��
		reader.close();							//����� ����
		System.out.println(new String(ch));	//���
		 */		
		
		//2�� -> ������ ���� ���(��ü ���)
		//ready() : �о�� ���ڰ� �ִµ��� true ��ȯ
		while(reader.ready()) {
			char ch = (char)reader.read();
			System.out.print(ch);
		}
		reader.close();
	
	}
}