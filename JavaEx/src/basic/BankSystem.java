package basic;
import java.util.Scanner;

public class BankSystem{
	
	public int[] bkacc;
	public String[] bkname;
	public int[] bkmoney;
	boolean run = true;
	public Scanner sc;
	Client c = new Client();

	public BankSystem() {
	sc = new Scanner(System.in);
	}
	
	public void mkAccount() {
		System.out.println("���Ͻô� ���� ���� ������ �Է����ּ���.");
		int acc = sc.nextInt();
		bkacc = new int[acc];
		bkname = new String[acc];
		bkmoney = new int[acc];
		
		for(int i=0;i<acc;i++) {
			System.out.println((i+1)+"��° �������� �̸��� �����ּ���!");
			String name = inputStr();
			bkname[i]=name;
			bkmoney[i]=0;
			
		}
		for(int i=0;i<bkacc.length;i++) {
			bkacc[i]=(int)(Math.random()*100000)+1;
			for(int j=0;j<i;j++) {
				if(bkacc[j]==bkacc[i])
					--i;
			}	
		}
		c.setAcc(bkacc);
		c.setMoney(bkmoney);
		c.setName(bkname);
	}
	
	public void inputMoney() {
		System.out.println("�Ա��Ͻ� �������� �̸��� �Է����ּ���!");
		String name=sc.next();
		
		int set=0;
		
		for(int i=0;i<bkname.length;i++) {
			if(name==bkname[i]) {
				set=i;
				return;
			}
		}
		System.out.println("�Ա��Ͻ� �ݾ��� �����ּ���!");
		int money = inputInt();
		
		c.getMoney()[set]+=money;
		
	}
	
	public void check() {
		System.out.println("��ȸ�Ͻ� �������� �̸��� �Է����ּ���!");
		
		String name=inputStr();
		
		int set=0;
		
		for(int i=0;i<bkname.length;i++) {
			if(name==bkname[i]) {
				set=i;
			}
		}
		
		for(int i=0;i<bkacc.length;i++) {
			if(c.getName()[i].equals(name)) {
			System.out.println("������ : "+c.getName()[i]);
			System.out.println("���¹�ȣ : "+c.getAcc()[i]);
			System.out.println("�ܾ� : "+c.getMoney()[i]);
			return;
			}
		}
	}
	
	public void outputMoney() {
		System.out.println("����Ͻ� �������� �̸��� �Է����ּ���!");
		String name=inputStr();
		
		int set=0;
		
		for(int i=0;i<bkname.length;i++) {
			if(name==bkname[i]) set=i;
		}
		System.out.println("����Ͻ� �ݾ��� �����ּ���!");
		int money = inputInt();
		
		c.getMoney()[set]-=money;
		
	}
	public void execute() {
		
		do {
		System.out.println("==================================================");
		System.out.println("      1.���»���      |      2.�Ա�      |      3.���      |      4.�м�      |     5.����   ");
		System.out.println("==================================================");
		System.out.print("����>\t");
		
		switch(inputInt()) {
		
		case 1:
			mkAccount();
			break;
			
		case 2:
			inputMoney();
			break;
			
		case 3:
			outputMoney();
			break;
			
		case 4:
			check();
			break;
			
		case 5:
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
		BankSystem bk = new BankSystem();
		bk.execute();
	}
}

class Client {
	
	private String[] name;
	private int[] acc;
	private int[] money;
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getAcc() {
		return acc;
	}
	public void setAcc(int[] acc) {
		this.acc = acc;
	}
	public int[] getMoney() {
		return money;
	}
	public void setMoney(int[] money) {
		this.money = money;
	}
	
}