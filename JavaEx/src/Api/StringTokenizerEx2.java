package Api;

import java.util.StringTokenizer;

public class StringTokenizerEx2 {

	public static void main(String[] args) {
		String str = "1|3.29|Java";
		String str1 = "2|4.345|Eclipse";
		StringTokenizer st;
		st = new StringTokenizer(str, "|", false);
		
		int s = st.countTokens();
		
		for(int i=0; i<s;i++) {
			if(i==0)
			System.out.println("ID : "+st.nextToken());
			else if(i==1)
				System.out.println("Price : "+st.nextToken());
			else
				System.out.println("Username : "+st.nextToken());
		}
		System.out.println("*********************");
		
		st = new StringTokenizer(str1, "|", false);
		s = st.countTokens();
		for(int i=0; i<s;i++) {
			if(i==0)
			System.out.println("ID : "+st.nextToken());
			else if(i==1)
				System.out.println("Price : "+st.nextToken());
			else
				System.out.println("Username : "+st.nextToken());
		}
		
	}
}
