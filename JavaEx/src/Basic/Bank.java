package Basic;
import java.util.Scanner;

public class Bank {

	public boolean run;
	Scanner sc =new Scanner(System.in);
	public Bank_Info[] list;
	public String id=null;
	public String pw=null;
	public int index=0;
	public int money=0;
	
	public void mkList() {
		System.out.println("���� �� ������ ������ �Է��ϼ���!");
		int num=inputInt();
		int acc=0;
		list = new Bank_Info[num];
		
		for(int i=0;i<num;i++) {
			System.out.println((i+1)+"��° ������ ID�� �Է��ϼ���!");
			String id = inputStr();
			System.out.println((i+1)+"��° ������ PW�� �Է��ϼ���!");
			String pw = inputStr();
			
				int r=(int)(Math.random()*100000)+1;
				for(int j=0;j<i;j++) {
					if(list[j].getAccount()==r)
						--i;
					else list[i].setAccount(r);
				}	
			list[i]=new Bank_Info();
			list[i].setId(id);
			list[i].setPw(pw);
			list[i].setMoney(0);
			list[i].setAccount(acc);
			
		}
		execute();
	}
	
	public void logIn() {
		System.out.println("ID�� �Է��ϼ���! : ");
		String name=inputStr();
		
		System.out.println("PW�� �Է��ϼ���! : ");
		String pawo =inputStr();
		
		for(int i=0;i<list.length;i++) {
			if(name.equals(list[i].getId())) {
				if(pawo.equals(list[i].getPw())) {
					id=list[i].getId();
					pw=list[i].getPw();
					index=i;
				}
			}
		}
		execute();
	}
	public void logOut() {
		id=null;
		pw=null;
		index=0;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		execute();
	}
	public void input() {
		if(id.equals(null)) {
			System.out.println("������ �����ϴ�.");
		}else {
		System.out.println("�Ա��Ͻ� �ݾ���? ");
		int mon = inputInt();
		int remon=list[index].getMoney()+mon;
		list[index].setMoney(remon);
		money=remon;
		}
		execute();
	}
	public void output() {
		if(id.equals(null)) {
			System.out.println("������ �����ϴ�.");
		}else {
		System.out.println("����Ͻ� �ݾ���? ");
		int mon = inputInt();
		int remon=list[index].getMoney()-mon;
		list[index].setMoney(remon);
		money=remon;
		}
		execute();
	}
	
	public void check() {
		System.out.print("��ȸ�Ͻ� ���´� : ");
		System.out.println("id : "+id+"  ���¹�ȣ : "+list[index].getAccount()+"  �ܾ� : "+money+"�Դϴ�.");
		execute();
	}
	public void execute() {
		
		do {
		System.out.println("=======================================================================");
		System.out.println("      1.���»���      |      2.�α���      |      3.�α׾ƿ�      |      4.�Ա�      |     5.���   |    6.�м�    |     7.����");
		System.out.println("=======================================================================");
		System.out.print("����>\t");
		
		switch(inputInt()) {
		
		case 1:
			mkList();
			break;
			
		case 2:
			logIn();
			break;
			
		case 3:
			logOut();
			break;
			
		case 4:
			input();
			break;
			
			
		case 5:
			output();
			break;
			
		case 6:
			check();
			break;
			
		case 7:
			run=false;
			break;
			
		default : 
			System.out.println("�߸��� �Է��Դϴ�!");
		}
	}while(run);
		
	}
	
	public String inputStr() {
		return sc.next();
	}
	public int inputInt() {
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		Bank b =new Bank();
		b.execute();
	}
}
