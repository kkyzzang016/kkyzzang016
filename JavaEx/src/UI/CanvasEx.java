package UI;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasEx extends Canvas implements ActionListener{

	public Frame f;
	public Image img;
	public Button b;
	public int x,y;
	public CanvasEx() {
		x=10; y=10;
		b = new Button("º¯°æ");
		Toolkit tool = Toolkit.getDefaultToolkit();
		img = tool.getImage("C:\\Users\\odae\\Desktop\\Git\\kkyzzang016\\JavaEx\\src\\UI\\duke.jpg");
		
		f = new Frame("Canvas Test");
		f.add(this, "Center");
		f.add(b, "South");
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
		x++;
		repaint();
		
	}
	public static void main(String[] args) {
		new CanvasEx();
	}
}
