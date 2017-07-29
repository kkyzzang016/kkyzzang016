package lambda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


interface Kimchiif{
	public void make(String s, String b);
	public static void mix() {
		System.out.println("김치완성!");
	}
}

public class Kimchi extends JFrame implements ActionListener{
	


	JPanel jp;
	JLabel j1, j2, j3, j4;
	JButton bu;
	Kimchiif kif;
	Kimchiif kifs;
	
	public Kimchi() {

		jp = new JPanel();
		j1 = new JLabel(" ");
		j2 = new JLabel(" ");
		j3 = new JLabel(" ");
		j4 = new JLabel(" ");
		bu = new JButton("만들기");
		bu.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(bu,"Center");
		add(j1,"North");
		add(j2,"East");
		add(j3,"West");
		add(j4,"South");
		
		setVisible(true);
		setSize(300,300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		
		kif= (String s, String b) -> {	//이 표현식의 대상 유형은 기능적 인터페이스 여야합니다.
			String result = s+b;
			if(result.equals("고추장배추")) {
				Kimchiif.mix();
				j4.setText("김치완성");
			}
		};
		kif.make("고추장", "배추");
	}
	public static void main(String[] args) {
		new Kimchi();
	}
}