package BankSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BankFirst extends JFrame implements ActionListener{
	private JFrame login_Jf;
	private JPanel loginJp;
	private JLabel login_ID, login_PW;
	private JTextField login_JID, login_JPW;
	private JButton login_loginB, login_newjoin, login_exit;

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

 	private void gbAdd(JComponent c, int x, int y, int w, int h){
	    gbc.gridx = x;
	    gbc.gridy = y;
	    gbc.gridwidth = w;
	    gbc.gridheight = h;
	     gb.setConstraints(c, gbc);
	     gbc.insets = new Insets(2, 2, 2, 2);
	     add(c, gbc);
   }
 	
	public BankFirst() {
		login_Jf = new JFrame("����");
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
	
	public BankFirst(int num) { //����ȭ��

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
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.

	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		//new BankFirst();
		new BankFirst(4);
	}

	
}
