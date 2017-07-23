package bankSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BankNewUI extends JFrame implements ActionListener{
	
	JTextField tfID;
	JTextField tfName;
	JTextField tfBirth;
	JComboBox<String> cbHP1;
	 JTextField tfHP1, tfHP2, tfHP3;
	 JTextField tfEmail;
	 JComboBox<String> cbEmail;
	 JPasswordField pfPW1, pfPW2;
	 JTextField acc;
	 JButton btnConfirm, btnJoin;
	 boolean idCheck;
	 BankMethod bm = new BankMethod();

	public BankNewUI() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 30));
		panel.setLayout(null);
		this.add(panel);

		// ȸ�� ���� ���� �Է�
		// ID
		JLabel IDlbl = new JLabel("���̵�");
		IDlbl.setForeground(Color.WHITE);
		IDlbl.setBounds(50, 30, 330, 90);
		panel.add(IDlbl);
		tfID = new JTextField(20); // ID�Է�ĭ  
		tfID.setBounds(100, 60, 160, 25);
		tfID.addActionListener(this);
		panel.add(tfID);
		btnConfirm = new JButton("�ߺ�Ȯ��");
		btnConfirm.setBounds(270, 60, 90, 25);
		btnConfirm.addActionListener(this);
		panel.add(btnConfirm);

		// PW
		JLabel PWlbl = new JLabel("�н�����");
		PWlbl.setForeground(Color.WHITE);
		PWlbl.setBounds(40, 60, 330, 90);
		panel.add(PWlbl);
		pfPW1 = new JPasswordField(20); // ��й�ȣ �Է�
		pfPW1.setBounds(100, 90, 160, 25);
		pfPW1.addActionListener(this);
		panel.add(pfPW1);

		//���� (��Ȱ��ȭ)
		JLabel ACClbl2 = new JLabel("�� ��");
		ACClbl2.setForeground(Color.WHITE);
		ACClbl2.setBounds(60, 120, 330, 90);
		panel.add(ACClbl2);
		acc = new JTextField(20); // ��й�ȣ Ȯ�� �Է�
		acc.setBounds(100, 150, 160, 25);
		acc.setBackground(Color.LIGHT_GRAY);  
		acc.setEnabled(false);
		panel.add(acc);

		// ����
		JLabel namelbl = new JLabel("�� ��");
		namelbl.setForeground(Color.WHITE);
		namelbl.setBounds(60, 150, 330, 90);
		panel.add(namelbl);
		tfName = new JTextField(20); // ID�Է�ĭ
		tfName.setBounds(100, 180, 160, 25);
		tfName.addActionListener(this);	
		panel.add(tfName);

		// �ֹε�Ϲ�ȣ
		JLabel birthlbl = new JLabel("�������");
		birthlbl.setForeground(Color.WHITE);
		birthlbl.setBounds(40, 180, 330, 90);
		panel.add(birthlbl);			
		tfBirth = new JTextField(6); // ������� �Է�ĭ
		tfBirth.setBounds(100, 210, 80, 25);
		tfBirth.addActionListener(this);
		panel.add(tfBirth);
		JLabel birthlbl2 = new JLabel("�ֹε�Ϲ�ȣ ���ڸ��� �Է�");
		birthlbl2.setForeground(Color.WHITE);
		birthlbl2.setBounds(190, 180, 330, 90);
		panel.add(birthlbl2);

		// �ڵ���
		JLabel hplbl = new JLabel("�ڵ�����ȣ");   
		hplbl.setForeground(Color.WHITE);
		hplbl.setBounds(25, 210, 330, 90);
		panel.add(hplbl);
		//tfHP1 = new JTextField(4); // ��ȣ �Է�ĭ
		String[] hp = {"010","011","016","017","018"};
		/*cbHP1 = new JComboBox<String>(hp);
		cbHP1.setBounds(100, 240, 50, 25);
		cbHP1.addActionListener(this);*/
		tfHP1 = new JTextField(3);
		tfHP1.setBounds(100, 240, 50, 25);
		tfHP1.addActionListener(this);
		panel.add(tfHP1);
		tfHP2 = new JTextField(4);
		tfHP2.setBounds(155, 240, 50, 25);
		tfHP2.addActionListener(this);
		panel.add(tfHP2);
		tfHP3 = new JTextField(4);
		tfHP3.setBounds(210, 240, 50, 25);
		tfHP3.addActionListener(this);
		panel.add(tfHP3);

		// ���
		btnJoin = new JButton("��  ��");
		btnJoin.setBounds(150, 300, 100, 30);
		panel.add(btnJoin);
		btnJoin.addActionListener(this);
		btnJoin.setVisible(false);
		
		setVisible(true);
		setSize(430, 400);
		setLocation(800, 450);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
        setDefaultCloseOperation(EXIT_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();

		if(ob==btnJoin){
			String phone = bm.addString(tfHP1.getText(), tfHP2.getText(), tfHP3.getText());
			String total = bm.addString(tfID.getText(), pfPW1.getText(), tfName.getText(), bm.accMake(), phone, tfBirth.getText());
			bm.clientIn(total);
			bm.out(bm.in()+total);
			dispose();
			new BankLoginUI();
		}
		if(ob==btnConfirm){
			boolean flag=bm.confirm(tfID.getText());
			if(flag==true){
				JOptionPane.showMessageDialog(btnConfirm, "��밡���� ID�Դϴ�!");
				btnJoin.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(btnConfirm, "�ߺ��� ID�Դϴ�. �ٸ�ID�� �Է����ּ���!");
				btnJoin.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args) {
		new BankNewUI();
	}
	
	}


