package bankSystem;

import javax.swing.JOptionPane;

public class BankMethod {
	
		public BankClientInfo[] list;
		
		public void init() {
			String num=JOptionPane.showInputDialog("생성할 계좌의 수를 입력하세요!");
			int i=Integer.parseInt(num);
			list = new BankClientInfo[i];
			
			BankLoginUI bl = new BankLoginUI();
		}
		public static void main(String[] args) {
			BankMethod bm = new BankMethod();
			bm.init();
		}
	}

