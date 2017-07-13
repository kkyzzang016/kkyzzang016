package generic;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		
	Vector vc = new Vector();

	vc.add("홍길동");
	vc.add("칠득이");
	vc.add("만득이");
	
	String s = (String)vc.get(0);
	String s1 = (String)vc.get(1);
	String s2 = (String)vc.get(2);
	
	System.out.println(s);
	System.out.println(s1);
	System.out.println(s2);
	
	System.out.print("이름 입력하세요. : ");
	String name = new Scanner(System.in).next();
	int index = vc.indexOf(name);
	
	if(vc.contains(name)) {
		System.out.println("검색결과 있음 : "+vc.get(index));
		if(vc.remove(name)) {
			System.out.println("삭제 완료");
		}
		System.out.println("<< 출력 결과 표현 1 >>");
		for(int i=0; i<vc.size(); i++) {
			Object obj = vc.get(i);
			String str = (String)obj;
			System.out.println(str);
		}
		
		System.out.println("<< 출력 결과 표현 2 >>");
		Iterator it = vc.iterator();
		while(it.hasNext()) {
			String n = (String)it.next();
			System.out.println(n);
		}
		
		System.out.println("<< 출력 결과 표현 3 >>");
		Enumeration e = vc.elements();
		while(e.hasMoreElements()) {
			Object obj = e.nextElement();
			String str = (String)obj;
			System.out.println(str);
		}
		
		System.out.println("<< 출력 결과 표현 4 >>");
		for(Object obj : vc) {
			String str = (String)obj;
			System.out.println(str);
		}
	}else {
		System.out.println("검색결과 없음");
	}
	
	}
}
