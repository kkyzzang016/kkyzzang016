package JavaExam_2W.Swing.TotoLadder;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateFrame2 extends JFrame{

	Container cp;
	JTextField tfid,tfname,tfbd,tfhp,tfjoin,tfemail,tfpoint;
	JTextArea tfpw;
	JButton btnMod;
	String num; //수정할 번호
	
	public UpdateFrame2(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		cp = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(250, 250, 200, 350);
		cp.setBackground(new Color(0, 0, 30));
		initDesign();
		//this.setVisible(true);
	}
	
	public void initDesign(){
		
		this.setLayout(null);
		
		JLabel title1 = new JLabel("ID");
		JLabel title2 = new JLabel("pw");
		JLabel title3 = new JLabel("이름");
		JLabel title4 = new JLabel("생년월일");
		JLabel title5 = new JLabel("핸드폰");
		JLabel title6 = new JLabel("가입일자");
		JLabel title7 = new JLabel("이메일");
		JLabel title8 = new JLabel("포인트");
		
		
		
		tfid=new JTextField(10);
		tfid.layout();
		tfpw=new JTextArea();
		tfpw.layout();
		tfname=new JTextField(10);
		tfbd=new JTextField(10);
		tfhp=new JTextField(10);
		tfjoin=new JTextField(10);
		tfjoin.layout();
		tfemail=new JTextField(10);
		tfpoint=new JTextField(10);
		
		
		
		btnMod=new JButton("수정");
		
		//라벨 위치잡고 프레임에 추가
		title1.setBounds(30, 10, 60, 30);
		this.add(title1);
		title2.setBounds(30, 40, 60, 30);
		this.add(title2);
		title3.setBounds(30, 70, 60, 30);
		this.add(title3);
		title4.setBounds(30, 100, 60, 30);
		this.add(title4);
		title5.setBounds(30, 130, 60, 30);
		this.add(title5);
		title6.setBounds(30, 160, 60, 30);
		this.add(title6);
		title7.setBounds(30, 190, 60, 30);
		this.add(title7);
		title8.setBounds(30, 220, 60, 30);
		this.add(title8);
		
		//텍스트필드 위치잡고 프레임에 추가
		tfid.setBounds(90, 10, 70, 22);
		this.add(tfid);
		
		tfpw.setBounds(90, 40, 70, 22);
		this.add(tfpw);
		
		tfname.setBounds(90, 70, 70, 22);
		this.add(tfname);
		
		tfbd.setBounds(90, 100, 70, 22);
		this.add(tfbd);
		
		tfhp.setBounds(90, 130, 70, 22);
		this.add(tfhp);
		
		tfjoin.setBounds(90, 160, 70, 22);
		this.add(tfjoin);
		
		tfemail.setBounds(90, 190, 70, 22);
		this.add(tfemail);
		
		tfpoint.setBounds(90, 220, 70, 22);
		this.add(tfpoint);
		
		//버튼
		btnMod.setBounds(90, 250, 60, 20);
		this.add(btnMod);
	}
	
	
	public static void main(String args[]){
		
		//new UpdateFrame2("성적관리");
	}
}
