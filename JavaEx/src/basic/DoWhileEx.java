package basic;
public class DoWhileEx {

	public static void main(String[] args) {
		int count =0;
		/*do {
			count++;
			System.out.println("���౸�� " + count);
		}while(count<10);*/
		
		//������ 9�ܱ��� ���
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
