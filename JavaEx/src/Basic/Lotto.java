package Basic;
import java.util.Scanner;

public class Lotto {
	
	public int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("베팅할 금액을 입력하시오! :  ");
		int bet=sc.nextInt()/1000;
		
		return bet;
	}
	public int[] making(int[] a) {
		
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) {
				if(a[j]==a[i])
					--i;
			}
		}
		return a;
	}
	
	public int[] sort(int[] a) {
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<i;j++) {
				if(a[j]>a[i]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
	}
	
	public void display(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
	}
	
	public static void main(String[] args) {
		
		Lotto l = new Lotto();
		int lot[] = new int[6];
		
		int bet = l.input();
		
		for(int i=0;i<bet;i++) {
			lot=l.making(lot);
			lot=l.sort(lot);
			l.display(lot);
			System.out.println();
		}
	}
}