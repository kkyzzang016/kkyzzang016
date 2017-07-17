package bankSystem;

import javax.swing.JOptionPane;

public class BankMethod {
	
		int accsu=0;
		public int current=0;
		int [] acc;
		BankLoginUI bl = new BankLoginUI();
		BankNewUI bn;
		BankMainUI bm = new BankMainUI();
		public BankClientInfo[] list;
		//BankClientInfo bi = new BankClientInfo();
		
		public void init() {
			String num=JOptionPane.showInputDialog("생성할 계좌의 수를 입력하세요!");
			accsu=Integer.parseInt(num);
			System.out.println("execute");
			list = new BankClientInfo[accsu];
			for(int i=0;i<accsu;i++) {
				list[i] = new BankClientInfo();
			}
			
			bl.bankLoginUI();
			makeAccount();
		}
		
		public void clear(int su) {
			list[su].setId("");
			list[su].setPw("");
			list[su].setName("");
			list[su].setBirth(0);
			list[su].setPhone(0);
		}
		
		public void joinCleaner() {
			bn.tfID.setText(null);
			bn.pfPW1.setText(null);
			bn.tfName.setText(null);
			bn.tfBirth.setText(null);
			bn.cbHP1.setSelectedIndex(1);
			bn.tfHP2.setText(null);
			bn.tfHP3.setText(null);
		}
		
		public void makeAccount() {
			acc= new int[accsu];
			for(int i=0;i<accsu;i++) {
				acc[i]=(int)(Math.random()*100000)+1;
				for(int j=0;j<i;j++) {
					if(acc[i]==acc[j])
						i--;
				}
			}
			for(int i=0;i<accsu;i++) {
			System.out.println(acc[i]);
			}
		}
		
		public void newJoin() {
		
			bn = new BankNewUI();
			list[0].setId("asd");
			list[current].setPw(bn.pfPW1.getText());
			list[current].setName(bn.tfName.getText());
			list[current].setBirth(Integer.parseInt(bn.tfBirth.getText()));
			list[current].setAccount(acc[current]);
			String phone = (String)(bn.cbHP1.getSelectedItem())+bn.tfHP2.getText()+bn.tfHP3.getText();
			list[current].setPhone(Integer.parseInt(phone));
			current++;
			}
		}


