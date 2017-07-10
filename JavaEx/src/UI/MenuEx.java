package UI;

import java.awt.Canvas;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class MenuEx extends Frame implements ActionListener{

	public MenuBar mb;
	public Menu m;
	public Dialog dialog;
	public Canvas can;
	private MenuItem[] mi;
	public MenuEx() {
		mb = new MenuBar();
		m = new Menu("File");
		mi = new MenuItem[5];
		mi[0] = new MenuItem("New File");
		mi[1] = new MenuItem("Open File");
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
			dialog = new NewDialog(this);
			//dialog.setLayout(new FlowLayout());
			dialog.pack();
			dialog.setSize(200,200);
			dialog.setVisible(true);
			l.setText("저장 혹은 열기");
			dialog.add(l);
			FileDialog fd = new FileDialog(this, "저장 혹은 열기", FileDialog.LOAD);
			fd.setSize(200,200);
			fd.setVisible(true);
		}else if(o==mi[1]) {
			dialog = new NewDialog(this);
			//dialog.setLayout(new FlowLayout());
			dialog.pack();
			//dialog.setSize(200,200);
			dialog.setVisible(true);
			l.setText("불러오기");
			dialog.add(l);
		}else if(o==mi[2]) {
			dialog = new NewDialog(this);
			//dialog.setLayout(new FlowLayout());
			dialog.pack();
			//dialog.setSize(200,200);
			dialog.setVisible(true);
			l.setText("저장하기");
			dialog.add(l);
			FileDialog fd = new FileDialog(this, "저장", FileDialog.SAVE);
			fd.setSize(200,200);
			fd.setVisible(true);
		}else if(o==mi[3]) {
			dialog = new NewDialog(this);
			//dialog.setLayout(new FlowLayout());
			dialog.pack();
			//dialog.setSize(200,200);
			dialog.setVisible(true);
			l.setText("다른이름으로 저장하기");
			dialog.add(l);
			FileDialog fd = new FileDialog(this, "저장 혹은 열기", FileDialog.LOAD);
			fd.setSize(200,200);
			fd.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}
	
}
class NewDialog extends JDialog{
	public NewDialog(MenuEx menuEx) {
		super(menuEx);
	}
}