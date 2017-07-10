package UI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FunnyScrollBar extends Frame implements AdjustmentListener,ActionListener{

	int r=255;
	int g=255;
	int b=255;
	Color c = new Color(r,g,b);
	Scrollbar sb1,sb2,sb3;
	TextField tf ;
	
	TextArea ta;
	Button a;
	Button a1;

	public FunnyScrollBar() {
		
		Frame fr = new Frame("gg");
		fr.setLayout(new GridLayout(1, 2));
		Panel p = new Panel();
		p.setLayout(new GridLayout(11, 1));
		Panel p1 = new Panel();
		p1.setLayout(new BorderLayout());
		fr.add(p, p1);
		a=new Button("최소");
		a.addActionListener(this);
		a1=new Button("최대");
		a1.addActionListener(this);
		sb1 = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		sb1.addAdjustmentListener(this);
		sb2 = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		sb2.addAdjustmentListener(this);
		sb3 = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		sb3.addAdjustmentListener(this);
		
		Label l1 = new Label("");
		Label l2 = new Label("");
		Label l3 = new Label("");
		Label l4 = new Label("");
		Label l5 = new Label("");
		Label l6 = new Label("");
		Label l7 = new Label("");
		Label l8 = new Label("");
		Label l9 = new Label("현재 색상");
		ta = new TextArea();
		ta.setBackground(c);
		tf = new TextField("R : G : B : ");
		
		p.add(l1);
		p.add(sb1);
		p.add(l2);
		p.add(sb2);
		p.add(l3);
		p.add(sb3);
		p.add(l4);
		p.add(l9);
		p.add(tf);
		p.add(a1);
		p.add(a);
		
		p1.add(l5,BorderLayout.NORTH);
		p1.add(l6,BorderLayout.WEST);
		p1.add(l7,BorderLayout.EAST);
		p1.add(l8,BorderLayout.SOUTH);
		p1.add(ta,BorderLayout.CENTER);
		
		fr.add(p);
		fr.add(p1);
		fr.setSize(500,500);
		fr.setVisible(true);
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new FunnyScrollBar();
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
			//getRed()
			//getGreen()
			//getBlue()
		r=255-sb1.getValue();
		g=255-sb2.getValue();
		b=255-sb3.getValue();
		tf.setText("R : "+r+"  G : "+g+" B : "+b);
		c=new Color(r,g,b);
		ta.setBackground(c);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==a) {
			r=0;
			g=0;
			b=0;
			c=new Color(r,g,b);
			ta.setBackground(c);
		}
		if(e.getSource()==a1) {
			r=255;
			g=255;
			b=255;
			c=new Color(r,g,b);
			ta.setBackground(c);
		}
		
	}
}
