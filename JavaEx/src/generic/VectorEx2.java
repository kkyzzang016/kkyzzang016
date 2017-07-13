package generic;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorEx2 {

	public static void main(String[] args) {
		
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("����1","����1","�۾���1"));
		list.add(new Board("����2","����2","�۾���2"));
		list.add(new Board("����3","����3","�۾���3"));
		list.add(new Board("����4","����4","�۾���4"));
		list.add(new Board("����5","����5","�۾���5"));
		
		list.remove(2);
		list.remove(3);
		
		for(int i=0;i<list.size();i++) {
				Board b = list.get(i);
				System.out.println(b.subject + "\t"+b.content+"\t"+b.writer);
		}		
	}
}
