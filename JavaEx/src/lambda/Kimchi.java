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
		System.out.println("��ġ�ϼ�!");
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
		bu = new JButton("�����");
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
		
		kif= (String s, String b) -> {	//�� ǥ������ ��� ������ ����� �������̽� �����մϴ�.
			String result = s+b;
			if(result.equals("���������")) {
				Kimchiif.mix();
				j4.setText("��ġ�ϼ�");
			}
		};
		kif.make("������", "����");
	}
	public static void main(String[] args) {
		new Kimchi();
	}
}