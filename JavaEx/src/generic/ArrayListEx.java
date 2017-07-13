package generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("JAVA"); //add(index, "") 인덱스 생략하면 순서대로 추가, index 입력하면 해당 index에 추가
		list.add("JDBC");
		list.add("Servlet/JSP"); 
		list.add(2, "Database");
		list.add("iBATIS");
		
		int size=list.size();
		System.out.println("총 객체수 : "+size+"\n");
		
		String skill = list.get(2);
		System.out.println("2 : "+skill+"\n");
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+" : "+str);
		}System.out.println();
		
		list.remove(2); //remove(index) 해당 index의 값 삭제
		list.remove(2);
		list.remove("iBATIS"); //remove() index대신 문자열 가능
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+" : "+str);
		}
	}
}
