package bankSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankMainUI extends JFrame implements ActionListener{

	JFrame jf;
	JPanel [] jp;
	JCheckBox cin,cout;
	JTextField jmoney,jid,jacc;
	JLabel jlid,jlmoney,jlacc;
	
	public BankMainUI() {
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new BankMainUI();
	}

}
