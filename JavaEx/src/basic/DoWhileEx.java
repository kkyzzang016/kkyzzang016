package basic;
public class DoWhileEx {

	public static void main(String[] args) {
		int count =0;
		/*do {
			count++;
			System.out.println("실행구문 " + count);
		}while(count<10);*/
		
		//구구단 9단까지 출력
		int x=2;
		int y=1;
		do {
			do {
			System.out.print(x+"*"+y+"="+x*y+"\t");	
				y++;
			}while(y<=9);
			y=1;
			x++;
			System.out.println();
		}while(x<=9);
	}
}
