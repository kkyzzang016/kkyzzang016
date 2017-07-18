package io;

import java.awt.Canvas;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JDialog;

public class MenuIO extends Frame implements ActionListener{
	public MenuBar mb;
	public Menu m;
	public Dialog dialog;
	public Canvas can;
	public TextArea ta;
	private MenuItem[] mi;
	FileReader reader;
	FileWriter fw; 
	BufferedWriter bw; 
	PrintWriter pw; 
	File file;
	public MenuIO() {
		ta = new TextArea();
		mb = new MenuBar();
		m = new Menu("File");
		mi = new MenuItem[5];
		mi[0] = new MenuItem("Open File");
		mi[1] = new MenuItem("New File");
		mi[2] = new MenuItem("Save File");
		mi[3] = new MenuItem("Save As");
		mi[4] = new MenuItem("Exit");
		for(int i=0; i<mi.length;i++) {
			m.add(mi[i]);
			mi[i].addActionListener(this);
			if(i != 2 && i != (mi.length-1))
				m.addSeparator();
		}
		mi[1].setEnabled(false);
		mb.add(m);
		add(ta,"Center");
		setMenuBar(mb);
		setLocation(250, 250);
		setSize(500, 500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		NewDialog nd;
		Label l =new Label("");
		if(o==mi[4]) {
			System.exit(0);
			
			
		}else if(o==mi[0]) {
			FileDialog fd = new FileDialog(this, "불러오기", FileDialog.LOAD);
			fd.setSize(200,200);
			fd.setVisible(true);
			String dir = fd.getDirectory();
			String f = fd.getFile();
			String aa="";
			file = new File(dir+"/"+f);
			this.setTitle(f);
			try {
				reader = new FileReader(file);
				while(reader.ready()) {
					char ch = (char)reader.read();
					//System.out.print(ch);
					aa += Character.toString(ch);
				}
				ta.setText(aa);
				reader.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(o==mi[1]) {

		}else if(o==mi[2]) {
			
			if(file!=null) {
				try {
					fw = new FileWriter(file);
					bw = new BufferedWriter(fw);	
					pw = new PrintWriter(bw,true);	
					
					String str = ta.getText();
					pw.println(str);
					pw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 	
				file=null;
			}
			
			else {
			FileDialog fd = new FileDialog(this, "저장", FileDialog.SAVE);
			fd.setSize(200,200);
			fd.setVisible(true);
			String dir = fd.getDirectory();
			String f = fd.getFile();
			file = new File(dir+"/"+f);
			
			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);	
				pw = new PrintWriter(bw,true);	
				
				String str = ta.getText();
				pw.println(str);
				pw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.setTitle(f);
			file=null;
			}
			
			
		}else if(o==mi[3]) {
			FileDialog fd = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
			fd.setSize(200,200);
			fd.setVisible(true);
			String dir = fd.getDirectory();
			String f = fd.getFile();
			file = new File(dir+"/"+f);
			
			try {
				fw = new FileWriter(file+".txt");
				bw = new BufferedWriter(fw);	
				pw = new PrintWriter(bw,true);	
				
				String str = ta.getText();
				pw.println(str);
				pw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.setTitle(f);
			file=null;
			}
		}
	
	public static void main(String[] args) {
		new MenuIO();
	}
	
}
class NewDialog extends JDialog{
	public NewDialog(MenuIO fileIO) {
		super(fileIO);
	}
}