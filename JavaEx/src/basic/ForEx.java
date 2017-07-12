package basic;
public class ForEx {
	public static void main(String[] args) {
		
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				if(x>=y) System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				if(x+y<=4) System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				if(x+y<4) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				if(x>y) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int x=0;x<5;x++) {
			for(int y=0;y<10;y++) {
				if(x+y>3&&x+y<9)System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int x=0;x<5;x++) {
			for(int y=0;y<10;y++) {
				if(x+y<=4) System.out.print(" ");
				else if(y-x>5) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		for(int x=1;x<5;x++) {
			System.out.print(" ");
			for(int y=0;y<9;y++) {
				if(x+y>8) System.out.print(" ");
				else if(x>y) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
	}
}
