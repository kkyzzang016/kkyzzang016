package bankSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.border.BevelBorder;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;


public class woorijoin extends JFrame {


	private JPanel contentPane;

	private JTextField textField;

	private JTextField txtId;

	private JTextField txtId_1;

	private JTextField txtPw;

	private JTextField txtPW;

	private JTextField txtRpw;

	private JTextField txtRPW;

	private JTextField txtNick;

	private JTextField txtNick_1;

	private JTextField txtName;

	private JTextField txtName_1;

	private JTextField txtHp;

	private JTextField txtHP;

	private JTextField txtEmail;

	private JTextField txtEmail_1;

	private JTextField txtSex;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					woorijoin frame = new woorijoin();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}


	public woorijoin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 305, 573);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JPanel panel = new JPanel();

		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		panel.setBounds(0, 0, 289, 535);

		contentPane.add(panel);

		panel.setLayout(null);

		

		textField = new JTextField();

		textField.setEnabled(false);

		textField.setEditable(false);

		textField.setFont(new Font("����ü", Font.BOLD, 18));

		textField.setText("\uD68C \uC6D0 \uAC00 \uC785");

		textField.setBounds(97, 21, 116, 31);

		panel.add(textField);

		textField.setColumns(10);

		

		txtId = new JTextField();

		txtId.setEnabled(false);

		txtId.setEditable(false);

		txtId.setText("ID :");

		txtId.setBounds(51, 69, 33, 21);

		panel.add(txtId);

		txtId.setColumns(10);

		

		txtId_1 = new JTextField();

		txtId_1.setBounds(123, 69, 116, 21);

		panel.add(txtId_1);

		txtId_1.setColumns(10);

		

		JButton btnIDCheck = new JButton("IDCheck");

		btnIDCheck.setBounds(123, 100, 116, 23);

		panel.add(btnIDCheck);

		

		txtPw = new JTextField();

		txtPw.setText("PW :");

		txtPw.setEnabled(false);

		txtPw.setEditable(false);

		txtPw.setColumns(10);

		txtPw.setBounds(51, 133, 33, 21);

		panel.add(txtPw);

		

		txtPW = new JTextField();

		txtPW.setColumns(10);

		txtPW.setBounds(123, 133, 116, 21);

		panel.add(txtPW);

		

		txtRpw = new JTextField();

		txtRpw.setText("RPW :");

		txtRpw.setEnabled(false);

		txtRpw.setEditable(false);

		txtRpw.setColumns(10);

		txtRpw.setBounds(51, 172, 45, 21);

		panel.add(txtRpw);

		

		txtRPW = new JTextField();

		txtRPW.setColumns(10);

		txtRPW.setBounds(123, 172, 116, 21);

		panel.add(txtRPW);

		

		txtNick = new JTextField();

		txtNick.setText("Nick :");

		txtNick.setEnabled(false);

		txtNick.setEditable(false);

		txtNick.setColumns(10);

		txtNick.setBounds(51, 206, 45, 21);

		panel.add(txtNick);

		

		txtNick_1 = new JTextField();

		txtNick_1.setColumns(10);

		txtNick_1.setBounds(123, 206, 116, 21);

		panel.add(txtNick_1);

		

		JButton btnNickCheck = new JButton("NickCheck");

		btnNickCheck.setBounds(123, 238, 116, 23);

		panel.add(btnNickCheck);

		

		txtName = new JTextField();

		txtName.setText("Name :");

		txtName.setEnabled(false);

		txtName.setEditable(false);

		txtName.setColumns(10);

		txtName.setBounds(51, 273, 51, 21);

		panel.add(txtName);

		

		txtName_1 = new JTextField();

		txtName_1.setColumns(10);

		txtName_1.setBounds(123, 273, 116, 21);

		panel.add(txtName_1);

		

		txtHp = new JTextField();

		txtHp.setText("HP :");

		txtHp.setEnabled(false);

		txtHp.setEditable(false);

		txtHp.setColumns(10);

		txtHp.setBounds(51, 311, 33, 21);

		panel.add(txtHp);

		

		txtHP = new JTextField();

		txtHP.setColumns(10);

		txtHP.setBounds(123, 311, 116, 21);

		panel.add(txtHP);

		

		txtEmail = new JTextField();

		txtEmail.setText("Email :");

		txtEmail.setEnabled(false);

		txtEmail.setEditable(false);

		txtEmail.setColumns(10);

		txtEmail.setBounds(51, 347, 51, 21);

		panel.add(txtEmail);

		

		txtEmail_1 = new JTextField();

		txtEmail_1.setColumns(10);

		txtEmail_1.setBounds(123, 347, 116, 21);

		panel.add(txtEmail_1);

		

		txtSex = new JTextField();

		txtSex.setText("SEX :");

		txtSex.setEnabled(false);

		txtSex.setEditable(false);

		txtSex.setColumns(10);

		txtSex.setBounds(51, 387, 45, 21);

		panel.add(txtSex);

		

		JRadioButton rBM = new JRadioButton("\uB0A8\uC131");

		buttonGroup.add(rBM);

		rBM.setBounds(118, 386, 51, 23);

		panel.add(rBM);

		

		JRadioButton rBF = new JRadioButton("\uC5EC\uC131");

		buttonGroup.add(rBF);

		rBF.setBounds(188, 386, 51, 23);

		panel.add(rBF);

		

		JButton btnJoin = new JButton("\uAC00\uC785");

		btnJoin.setBounds(51, 465, 73, 23);

		panel.add(btnJoin);

		

		JButton btnCancel = new JButton("\uCDE8\uC18C");

		btnCancel.setBounds(166, 465, 73, 23);

		panel.add(btnCancel);

	}

}
/*
 * login_Jf = new JFrame("����");
		loginJp = new JPanel();
		login_ID = new JLabel("    login_ID : ");
		login_PW = new JLabel("    login_PW : ");	
		
		login_JID = new JTextField(20);
		login_JPW = new JTextField(20);
		login_loginB = new JButton("�α���");
		login_newjoin = new JButton("�ű�");
		login_exit = new JButton("����");
		
		loginJp.setBackground(Color.lightGray);
		login_ID.setBounds(20, 15, 80, 25);
		login_PW.setBounds(20, 60, 80, 25);
		login_JID.setBounds(100, 15, 160, 25);
		login_JPW.setBounds(100, 60, 160, 25);
		login_loginB.setBounds(270, 10, 80, 80);
		login_newjoin.setBounds(70, 100, 90, 30);
		login_exit.setBounds(210, 100, 90, 30);
		login_Jf.add(login_ID);
		login_Jf.add(login_PW);
		login_Jf.add(login_JID);
		login_Jf.add(login_JPW);
		login_Jf.add(login_loginB);
		login_Jf.add(login_newjoin);
		login_Jf.add(login_exit);
		login_Jf.add(loginJp);
		
		login_Jf.setTitle("����");
		login_Jf.setSize(370,165);
		login_Jf.setVisible(true);
		login_Jf.setLocation(800, 450);
		login_Jf.setResizable(false);
		login_Jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public BankUI(int num) { //����ȭ��

		this.setTitle("ȸ������");

        gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        //���̵�
        JLabel bId = new JLabel("���̵� : ");
        tfId = new JTextField(20);      
        
        //�׸���鿡 ���̱�
        gbAdd(bId, 0, 0, 1, 1);
        gbAdd(tfId, 1, 0, 3, 1);
 
        //��й�ȣ

        JLabel bPwd = new JLabel("��й�ȣ : ");
        pfPwd = new JPasswordField(20);
        gbAdd(bPwd, 0, 1, 1, 1);
        gbAdd(pfPwd, 1, 1, 3, 1);

        //�̸�
        JLabel bName = new JLabel("�̸� :");
        tfName = new JTextField(20);
        gbAdd(bName,0,2,1,1);
        gbAdd(tfName,1,2,3,1);    

        //��ȭ
        JLabel bTel = new JLabel("��ȭ :");
        JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tfTel1 = new JTextField(6);     
        tfTel2 = new JTextField(6);     
        tfTel3 = new JTextField(6);
        pTel.add(tfTel1);
        pTel.add(new JLabel(" - "));
        pTel.add(tfTel2); 
        pTel.add(new JLabel(" - "));
        pTel.add(tfTel3); 
        gbAdd(bTel, 0, 3, 1,1);
        gbAdd(pTel, 1, 3, 3,1);

        //�ּ�
        JLabel bAddr = new JLabel("�ּ�: ");
        tfAddr = new JTextField(20);
        gbAdd(bAddr, 0,4,1,1);
        gbAdd(tfAddr, 1, 4, 3,1);
        
        //����
        JLabel bBirth= new JLabel("����: ");
        tfYear = new JTextField(6);
        tfMonth = new JTextField(6);
        tfDate = new JTextField(6);
        JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pBirth.add(tfYear);
        pBirth.add(new JLabel("/"));
        pBirth.add(tfMonth);
        pBirth.add(new JLabel("/"));
        pBirth.add(tfDate);
        gbAdd(bBirth, 0,5,1,1);
        gbAdd(pBirth, 1, 5, 3,1);
   
        //����        
        JLabel bJob = new JLabel("���� : ");
        String[] arrJob = {"---", "�л�", "������", "�ֺ�"};
        cbJob = new JComboBox(arrJob);
        JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pJob.add(cbJob);        
        gbAdd(bJob, 0,6,1,1);
        gbAdd(pJob,1,6,3,1);

        //����
        JLabel bGender = new JLabel("���� : ");
        JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMan = new JRadioButton("��",true);
        rbWoman = new JRadioButton("��",true);
        ButtonGroup group = new ButtonGroup();
        group.add(rbMan);
        group.add(rbWoman);
        pGender.add(rbMan);
        pGender.add(rbWoman);       
        gbAdd(bGender, 0,7,1,1);
        gbAdd(pGender,1,7,3,1);
 
        //�̸���
        JLabel bEmail = new JLabel("�̸��� : ");
        tfEmail = new JTextField(20);
        gbAdd(bEmail, 0,8,1,1);
        gbAdd(tfEmail,1,8,3,1);

        //�ڱ�Ұ�
        JLabel bIntro = new JLabel("�ڱ� �Ұ�: ");
        taIntro = new JTextArea(5, 20); //�� : ��
        JScrollPane pane = new JScrollPane(taIntro);
        gbAdd(bIntro,0,9,1,1);
        gbAdd(pane,1,9,3,1);

        //��ư
        JPanel pButton = new JPanel();

        btnInsert = new JButton("����");
        btnUpdate = new JButton("����");  
        btnDelete = new JButton("Ż��");
        btnCancel = new JButton("���");      
        pButton.add(btnInsert);
        pButton.add(btnUpdate);
        pButton.add(btnDelete);
        pButton.add(btnCancel);     
        gbAdd(pButton, 0, 10, 4, 1);
        
        //��ư�� �����⸦ ������
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);
        btnDelete.addActionListener(this);

        setSize(350,500);
        setVisible(true);
        
        =======================
        //http://m.blog.naver.com/javaking75/140190272629
	private JPanel p;
	private JTextField tfId, tfName, tfAddr, tfEmail;
	private JTextField tfTel1, tfTel2, tfTel3; //��ȭ
	private JComboBox cbJob; //����
	private JPasswordField pfPwd; //��й�ȣ    
	private JTextField tfYear, tfMonth, tfDate; //�������
	private JRadioButton rbMan, rbWoman; //��, ��
	private JTextArea taIntro;
	private JButton btnInsert, btnCancel, btnUpdate,btnDelete; //����, ���, ���� , Ż�� ��ư
	private GridBagLayout gb;
	private GridBagConstraints gbc;
	===============================
	private void gbAdd(JComponent c, int x, int y, int w, int h){
	    gbc.gridx = x;
	    gbc.gridy = y;
	    gbc.gridwidth = w;
	    gbc.gridheight = h;
	     gb.setConstraints(c, gbc);
	     gbc.insets = new Insets(2, 2, 2, 2);
	     add(c, gbc);
   }//http://m.blog.naver.com/javaking75/140190272629
 	
 */