package io;

import java.io.IOException;

/*
*
* 용어
	- 스트림 : 일반적으로 데이터, 패킷 등의 일련의 연속성을 갖는 흐름을 의미한다. (흐르는 데이터 - 물의 흐름)
	
	- 입.출력 스트림(IO) : 데이터를 읽고 쓰는 구조를 프로그램의 구조로 모델링 해 놓은 것
	
	- 버퍼 : 데이터를 임시적으로 담아두는 공간
 
* 자바의 입출력 스트림 개념
	- 단 방향으로 흐름
	- 버퍼를 가질 수 있다.
   - FIFO(선입선출)의 구조
   - 문자(Character Stream), 바이트(byte Stream) 로 분류함
   
* 문자(Character Stream) 문자 최상위 스트림
	- Reader Class
		입력 스트림 : 문자 데이터를 읽어 들이는 스트림
	- Writer Class
		출력 스트림 : 문자 데이터를 출력하기 위한 스트림
		
* 바이트(byte Stream) 바이트 최상위 스트림
	- InputStream Class
		입력 스트림 : 바이트 데이터를 읽어 들이는 스트림
			(입력 최상위 스트림)
	- OutputStream Class
		
*/
public class IOEx {
	
	public static void main(String[] args) {
		System.out.println("입력 : ");//1자만 입 출력
		char ch = 'a';
		try {
			ch = (char)System.in.read();
		} catch (IOException e) {
			System.out.println("Exception : "+e.getMessage());
		}
		System.out.println("출력 : "+ch);
	}
}











