package uI;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventEx1 extends Frame implements ActionListener, AdjustmentListener,ItemListener{

	Button b1 ,b2;
	Scrollbar sb;
	Checkbox cb;
	public EventEx1() {
		// TODO Auto-generated constructor stub
		sb = new Scrollbar(Scrollbar.HORIZONTAL);
		cb = new Checkbox("실습");
		cb.addItemListener(this); 
		b1 = new Button("버튼1");
		b1.addActionListener(this);
		sb.addAdjustmentListener(this); 
		b2 = new Button("버튼2");
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		add(b1,"West");
		add(b2,"East");
		add(sb,"Center");
		add(cb,"North");
		setSize(300,300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button obj = (Button)e.getSource();
		System.out.println("event!!"+obj.getLabel());
		
	}
	public static void main(String[] args) {
		new EventEx1();
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("이벤트 발생 "+sb.getValue());
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("이벤트 발생 checkbox "+cb.getLabel());
		
	}

	
}
