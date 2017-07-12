package JavaExam_2W.Swing.TotoLadder;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddFrame extends JFrame{

	Container cp;
	JTextField tfName,tfJava,tfJsp,tfSpring;
	JComboBox<String> cbBan;
	JButton btnAdd;
	
	public AddFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		cp = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 200, 250);
		cp.setBackground(new Color(255, 255, 155));
		initDesign();
		//this.setVisible(true);
	}
	
	public void initDesign(){
		
		this.setLayout(null);
		
		JLabel title1 = new JLabel("이름");
		JLabel title2 = new JLabel("반");
		JLabel title3 = new JLabel("JAVA");
		JLabel title4 = new JLabel("JSP");
		JLabel title5 = new JLabel("SPRING");
		
		tfName=new JTextField(4);
		tfJava=new JTextField(3);
		tfJsp=new JTextField(3);
		tfSpring=new JTextField(3);
		
		String[]ban={"a반","b반","c반","d반"};
		cbBan=new JComboBox<String>(ban);
		
		btnAdd=new JButton("추가");
		
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
		
		//텍스트필드,ban 위치잡고 프레임에 추가
		tfName.setBounds(90, 15, 70, 22);
		this.add(tfName);
		
		cbBan.setBounds(90, 45, 70, 22);
		this.add(cbBan);
		
		tfJava.setBounds(90, 75, 70, 22);
		this.add(tfJava);
		
		tfJsp.setBounds(90, 105, 70, 22);
		this.add(tfJsp);
		
		tfSpring.setBounds(90, 135, 70, 22);
		this.add(tfSpring);
		
		//버튼
		btnAdd.setBounds(65, 170, 60, 20);
		this.add(btnAdd);
	}
	
	
	public static void main(String args[]){
		
    	//new AddFrame("성적관리");
	}
}
