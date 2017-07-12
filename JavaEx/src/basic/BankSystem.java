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
		System.out.println("원하시는 계좌 생성 갯수를 입력해주세요.");
		int acc = sc.nextInt();
		bkacc = new int[acc];
		bkname = new String[acc];
		bkmoney = new int[acc];
		
		for(int i=0;i<acc;i++) {
			System.out.println((i+1)+"번째 계좌주의 이름을 적어주세요!");
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
		System.out.println("입금하실 계좌주의 이름을 입력해주세요!");
		String name=sc.next();
		
		int set=0;
		
		for(int i=0;i<bkname.length;i++) {
			if(name==bkname[i]) {
				set=i;
				return;
			}
		}
		System.out.println("입금하실 금액을 적어주세요!");
		int money = inputInt();
		
		c.getMoney()[set]+=money;
		
	}
	
	public void check() {
		System.out.println("조회하실 계좌주의 이름을 입력해주세요!");
		
		String name=inputStr();
		
		int set=0;
		
		for(int i=0;i<bkname.length;i++) {
			if(name==bkname[i]) {
				set=i;
			}
		}
		
		for(int i=0;i<bkacc.length;i++) {
			if(c.getName()[i].equals(name)) {
			System.out.println("계좌주 : "+c.getName()[i]);
			System.out.println("계좌번호 : "+c.getAcc()[i]);
			System.out.println("잔액 : "+c.getMoney()[i]);
			return;
			}
		}
	}
	
	public void outputMoney() {
		System.out.println("출금하실 계좌주의 이름을 입력해주세요!");
		String name=inputStr();
		
		int set=0;
		
		for(int i=0;i<bkname.length;i++) {
			if(name==bkname[i]) set=i;
		}
		System.out.println("출금하실 금액을 적어주세요!");
		int money = inputInt();
		
		c.getMoney()[set]-=money;
		
	}
	public void execute() {
		
		do {
		System.out.println("==================================================");
		System.out.println("      1.계좌생성      |      2.입금      |      3.출금      |      4.분석      |     5.종료   ");
		System.out.println("==================================================");
		System.out.print("선택>\t");
		
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
			System.out.println("잘못된 입력입니다!");
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