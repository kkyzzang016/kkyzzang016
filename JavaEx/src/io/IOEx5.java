package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOEx5 {

	public static void main(String[] args) throws IOException{
		FileReader reader = new FileReader(new File("C:/Users/odae/Desktop/Git/kkyzzang016/JavaEx/src/io/IOEx5_sample.txt"));
		
		//배열을 사용하여 파일의 문자 읽어 출력하시오
		
		/* 1번
		char ch[] = new char[100];			//배열을 사용하여 100문자 공간확보
		reader.read(ch, 0, 100);				//100자 까지만 읽어옴
		reader.close();							//사용후 닫음
		System.out.println(new String(ch));	//출력
		 */		
		
		//2번 -> 파일의 문자 출력(전체 출력)
		//ready() : 읽어올 문자가 있는동안 true 반환
		while(reader.ready()) {
			char ch = (char)reader.read();
			System.out.print(ch);
		}
		reader.close();
	
	}
}