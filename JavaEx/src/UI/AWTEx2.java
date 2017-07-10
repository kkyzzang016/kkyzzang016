package UI;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTEx2 extends Frame implements ItemListener, ActionListener{

	Choice cho;
	Checkbox ch1,ch2,ch3,ch4,ch5,ch6;
	TextArea ta;
	public String str;
	
	
	public AWTEx2() {
		Frame f = new Frame();
		f.setLayout(new BorderLayout());
		Panel p = new Panel();
		Panel pC = new Panel();
		p.setLayout(new BorderLayout());
		pC.setLayout(new GridLayout(2, 4));

		
		Label l1 = new Label("");
		Label l2 = new Label("");
		Label l3 = new Label("");
		Label l4 = new Label("");
		Label l5 = new Label("");
		Label l6 = new Label("");
		
		ta = new TextArea("<<자바 수강생 식사>>");
		
		ch1 = new Checkbox("사과", false);
		ch1.addItemListener(this);
		ch2 = new Checkbox("딸기", false);
		ch2.addItemListener(this);
		ch3 = new Checkbox("배", false);
		ch3.addItemListener(this);
		
		
		CheckboxGroup ch = new CheckboxGroup();
		
		ch4 = new Checkbox("아침", false,ch);
		ch4.addItemListener(this);
		ch5 = new Checkbox("점심", false,ch);
		ch5.addItemListener(this);
		ch6 = new Checkbox("저녁", false,ch);
		ch6.addItemListener(this);
		pC.add(l5);
		pC.add(ch4);
		pC.add(ch5);
		pC.add(ch6);
		
		pC.add(l6);
		pC.add(ch1);
		pC.add(ch2);
		pC.add(ch3);
		
		cho = new Choice();
		cho.add("아침");
		cho.add("점심");
		cho.add("저녁");
		cho.addItemListener(this);
		
		p.add(pC,BorderLayout.NORTH);
		p.add(ta,BorderLayout.CENTER);
		p.add(cho,BorderLayout.SOUTH);
		
		f.add(p,BorderLayout.CENTER);
		f.add(l1, BorderLayout.NORTH);
		f.add(l2, BorderLayout.EAST);
		f.add(l3, BorderLayout.WEST);
		f.add(l4, BorderLayout.SOUTH);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLocation(700, 200);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new AWTEx2();
	}

	public void itemStateChanged(ItemEvent e) {
	
		String str1="1. 사과 :";
		String str2="2. 딸기 : ";
		String str3="3. 배    :";
		
	if(e.getSource()==ch4) {
		str="<<"+ch4.getLabel()+">>";
		ta.setText(str);
		cho.select(ch4.getLabel());
	}
	if(e.getSource()==ch5) {
		str="<<"+ch5.getLabel()+">>";
		ta.setText(str);
		cho.select(ch5.getLabel());
	}
	if(e.getSource()==ch6) {
		str="<<"+ch6.getLabel()+">>";
		ta.setText(str);
		cho.select(ch6.getLabel());
	}
	if(ch1.getState()) {
		str1+="true";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
	}else {
		str1+="false";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
	}
	if(ch2.getState()) {
		str2+="true";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
	}else {
		str2+="false";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
	}
	if(ch3.getState()) {
		str3+="true";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
	}else {
		str3+="false";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
	}
	if(e.getItem()==cho.getSelectedItem()) {
		if(cho.getSelectedItem()=="아침") {
			str="<<"+ch4.getLabel()+">>";
			ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
			ch4.setState(true);
		}
		else if(cho.getSelectedItem()=="점심") {
			str="<<"+ch5.getLabel()+">>";
			ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
			ch5.setState(true);
			
		}else {str="<<"+ch6.getLabel()+">>";
		ta.setText(str+"\n"+str1+"\n"+str2+"\n"+str3);
		ch6.setState(true);
		}
	}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
