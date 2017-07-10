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
		System.out.println("생성 할 계좌의 갯수를 입력하세요!");
		int num=inputInt();
		int acc=0;
		list = new Bank_Info[num];
		
		for(int i=0;i<num;i++) {
			System.out.println((i+1)+"번째 계좌의 ID를 입력하세요!");
			String id = inputStr();
			System.out.println((i+1)+"번째 계좌의 PW를 입력하세요!");
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
		System.out.println("ID를 입력하세요! : ");
		String name=inputStr();
		
		System.out.println("PW를 입력하세요! : ");
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
		System.out.println("로그아웃 되었습니다.");
		execute();
	}
	public void input() {
		if(id.equals(null)) {
			System.out.println("정보가 없습니다.");
		}else {
		System.out.println("입금하실 금액은? ");
		int mon = inputInt();
		int remon=list[index].getMoney()+mon;
		list[index].setMoney(remon);
		money=remon;
		}
		execute();
	}
	public void output() {
		if(id.equals(null)) {
			System.out.println("정보가 없습니다.");
		}else {
		System.out.println("출금하실 금액은? ");
		int mon = inputInt();
		int remon=list[index].getMoney()-mon;
		list[index].setMoney(remon);
		money=remon;
		}
		execute();
	}
	
	public void check() {
		System.out.print("조회하신 계좌는 : ");
		System.out.println("id : "+id+"  계좌번호 : "+list[index].getAccount()+"  잔액 : "+money+"입니다.");
		execute();
	}
	public void execute() {
		
		do {
		System.out.println("=======================================================================");
		System.out.println("      1.계좌생성      |      2.로그인      |      3.로그아웃      |      4.입금      |     5.출금   |    6.분석    |     7.종료");
		System.out.println("=======================================================================");
		System.out.print("선택>\t");
		
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
		Bank b =new Bank();
		b.execute();
	}
}
