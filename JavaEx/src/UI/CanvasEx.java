package UI;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasEx extends Canvas implements ActionListener{

	public Frame f;
	public Image img;
	public Button b,left,up,down,right;
	public int x,y;
	public Panel p;
	public Label l1, l2;
	public CanvasEx() {
		x=50; y=50;
		p = new Panel();
		p.setLayout(new GridLayout(2,3));
		
		l1 = new Label("");
		l2 = new Label("");
		
		b = new Button("º¯°æ");
		left = new Button("<");
		up = new Button("^");
		down = new Button("v");
		right = new Button(">");
		
		left.addActionListener(this);
		up.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		img = tool.getImage("C:\\Users\\odae\\Desktop\\Git\\kkyzzang016\\JavaEx\\src\\UI\\duke.jpg");
		
		p.add(l1);
		p.add(up);
		p.add(l2);
		p.add(left);
		p.add(down);
		p.add(right);
		
		f = new Frame("Canvas Test");
		f.add(this, "Center");
		f.add(p, "South");
		//f.add(b, "South");
		f.setSize(500,500);
		f.setVisible(true);
		b.addActionListener(this);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		//g.drawRect(x, y, 10, 10);
		g.drawImage(img, x, y, this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==up) {
			y--;
			repaint();
		}
		if(e.getSource()==down) {
			y++;
		repaint();
		}
		if(e.getSource()==left) {
			x--;
			repaint();
		}
		if(e.getSource()==right) {
				x++;
				repaint();
		}
		
	}
	public static void main(String[] args) {
		new CanvasEx();
	}
}
