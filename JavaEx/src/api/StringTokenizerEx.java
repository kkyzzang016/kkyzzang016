package api;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		String str = "자바 SE, 자바 EE, 자바 ME";
		String delim = args[0];
		StringTokenizer st;
		st = new StringTokenizer(str, delim, false);
		
		int count = 0;
		while(st.hasMoreTokens()) {
			System.out.println("자바과정"+ ++count + " : " + st.nextToken());
		}
		System.out.println(st.countTokens());
		
		for(int i=0; i<st.countTokens();i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
	

}