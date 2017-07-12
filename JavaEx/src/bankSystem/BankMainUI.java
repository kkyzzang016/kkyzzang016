package bankSystem;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankMainUI extends JFrame{

	JFrame jf;
	JPanel [] jp;
	JCheckBox cin,cout;
	JTextField jmoney,jid,jacc;
	JLabel jlid,jlmoney,jlacc;
	
	public BankMainUI() {
		
	}
	public static void main(String[] args) {
		new BankMainUI();
	}
}
