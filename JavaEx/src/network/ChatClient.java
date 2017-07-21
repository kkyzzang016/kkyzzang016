package network;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable,ActionListener{

	private BufferedReader i;
	private PrintWriter o;
	private JTextArea output;
	private JTextField input;
	private JLabel label;
	private String host;
	private Thread listener;
	private JScrollPane scp;
	private Vector<String> listall;
	private JList<String>list;
	private String delim = "#";
	private StringTokenizer st;
	private String code = "100|";
	
	public ChatClient(String server) {
		super("채팅 프로그램");
		host = server;
		listener = new Thread(this);
		listener.start();
		
		scp = new JScrollPane();
		output = new JTextArea();
		output.setEditable(false);
		add(scp, "Center");
		scp.setViewportView(output);
		list = new JList<String>();
		list.setVisible(true);
		add(list,"East");
		/*scp.setVerticalScrollBarPolicy(scp.VERTICAL_SCROLLBAR_ALWAYS);
		scp.setHorizontalScrollBarPolicy(scp.HORIZONTAL_SCROLLBAR_NEVER);*/
		Panel bottom = new Panel(new BorderLayout());
		label = new JLabel("사용자이름");
		bottom.add(label, "West");
		input = new JTextField();
		input.addActionListener(this);
		bottom.add(input, "Center");
		
		add(bottom,"South");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
		
		listall = new Vector<String>();
	}

	public void run() {
		try {
			Socket s = new Socket(host, 9000);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i= new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os),true);
			while(true) {
				String line = i.readLine();		//여기서 올림
				st = new StringTokenizer(line, delim, false);
				int su = st.countTokens();
				listall.removeAll(listall);
				for(int i=0; i<su;i++) {
					if(i==0) {
						output.append(st.nextToken()+"\n");
					}
					else {
						listall.add(st.nextToken());
					}
				}
				scp.getVerticalScrollBar().setValue(scp.getVerticalScrollBar().getMaximum());
				list.setListData(listall);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if(c==input) {
			label.setText("메시지");
			if(input.getText().equals("종료")) {
				o.println("300|"+input.getText());
				System.exit(0);
			}
			else {
			o.println(code+input.getText());
			}
			code="200|";
			input.setText("");
		}
	}
	
	public static void main(String[] args) {
		if(args.length>0) {
			new ChatClient(args[0]);
		}
		else {
			new ChatClient("localhost");
		}
	}
}
