package bankSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AddressSearch extends JFrame implements ActionListener, ListSelectionListener{

	JLabel jl;
	JTextField jt;
	JButton button;
	JList<String> list;
	Vector<String> listall;
	JScrollPane js;
	JPanel jp1, jp2;
	String str="";
	BankMethod bm = new BankMethod();
	public AddressSearch() {
		
		listall = new Vector<String>();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jl = new JLabel("동");
		jl.setBounds(20, 55, 30, 30);
		jt = new JTextField(25);
		jt.setBounds(80, 60, 200, 20);
		button = new JButton("검색");
		button.setBounds(290, 60, 100, 20);
		button.addActionListener(this);
		list = new JList<String>();
		list.addListSelectionListener(this);
		js = new JScrollPane(list);
		js.setBounds(20, 180, 200, 200);
		
		jp1.add(jl);
		jp1.add(jt);
		jp1.add(button);
		add(jp1,"North");
		add(js,"Center");
		setVisible(true);
		setSize(430, 400);
		setLocation(300, 300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void search(String str) {
		 DBAction db = DBAction.getInstance();
	      Connection conn = db.getConnection();
	      
	      if(str.charAt(str.length()-1) == '동'||str.charAt(str.length()-1) == '면') {
	      int len = str.length();
	      str = str.substring(0,len-1);
	      //System.out.println(str);
	      }
	      
	      String sql = "select * from zipcode where DONG like '"+str+"%'";
	      String temp="";
	      Statement stmt = null;
	      ResultSet rs = null;
	      ResultSetMetaData rsmd = null;
	      try{
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);
	         rsmd = rs.getMetaData();
	         int cols = rsmd.getColumnCount();
	         while(rs.next()) {
	        	 for(int i=1;i<=cols;i++) {
	        		 temp += rs.getString(i)+" ";
	        		 if(i==cols) temp+="";
	        	 }
	        	 listall.add(temp);
	        	 temp="";
	         }
	         
	      }catch(SQLException e){
	         e.printStackTrace();
	      }finally {
				try {
					rs.close();
					stmt.close();
					//conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      }
	      list.setListData(listall);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==button) {
			search(jt.getText());
		}
	}
	public void valueChanged(ListSelectionEvent lse) {
		
		if(!lse.getValueIsAdjusting()) {
			str = list.getSelectedValue();
			dispose();
			BankNewUI.add.setText(str);
		}
	}
}