package bankSystem;

import javax.swing.JOptionPane;

public class BankMethod {
	
		public BankClientInfo[] list;
		
		public void init() {
			String num=JOptionPane.showInputDialog("������ ������ ���� �Է��ϼ���!");
			int i=Integer.parseInt(num);
			list = new BankClientInfo[i];
			
			BankLoginUI bl = new BankLoginUI();
		}
		public static void main(String[] args) {
			BankMethod bm = new BankMethod();
			bm.init();
		}
	}

