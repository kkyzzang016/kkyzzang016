package bankSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfBirth;
	private JComboBox<String> cbHP1;
	private JTextField tfHP1, tfHP2, tfHP3;
	private JTextField tfEmail;
	private JComboBox<String> cbEmail;
	private JPasswordField pfPW1, pfPW2;
	private JTextField acc;
	private JButton btnConfirm, btnJoin;
	private boolean idCheck;
	
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
		panel.add(pfPW1);

		// PWȮ��
		JLabel PWlbl2 = new JLabel("Ȯ ��");
		PWlbl2.setForeground(Color.WHITE);
		PWlbl2.setBounds(60, 90, 330, 90);
		panel.add(PWlbl2);
		pfPW2 = new JPasswordField(20); // ��й�ȣ Ȯ�� �Է�
		pfPW2.setBounds(100, 120, 160, 25);
		panel.add(pfPW2);
		
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
		panel.add(tfName);

		// �ֹε�Ϲ�ȣ
		JLabel birthlbl = new JLabel("�������");
		birthlbl.setForeground(Color.WHITE);
		birthlbl.setBounds(40, 180, 330, 90);
		panel.add(birthlbl);
		tfBirth = new JTextField(6); // ������� �Է�ĭ
		tfBirth.setBounds(100, 210, 80, 25);
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
		cbHP1 = new JComboBox<String>(hp);
		cbHP1.setBounds(100, 240, 50, 25);
		panel.add(cbHP1);
		tfHP2 = new JTextField(4);
		tfHP2.setBounds(155, 240, 50, 25);
		panel.add(tfHP2);
		tfHP3 = new JTextField(4);
		tfHP3.setBounds(210, 240, 50, 25);
		panel.add(tfHP3);

		// ���
		btnJoin = new JButton("��  ��");
		btnJoin.setBounds(150, 300, 100, 30);
		panel.add(btnJoin);
		btnJoin.addActionListener(this);
		
		setVisible(true);
		setSize(430, 400);
		setLocation(800, 450);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
        setDefaultCloseOperation(EXIT_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin)
			this.setVisible(false);
			new BankLoginUI();
		
	}

}
