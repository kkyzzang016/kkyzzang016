package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;

public class ChatHandler extends Thread{

	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer server;
	
	
	public ChatHandler(ChatServer server, Socket s) throws IOException{
		
		this.s=s;
		this.server=server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i= new BufferedReader(new InputStreamReader(ins));
		o = new PrintWriter(new OutputStreamWriter(os), true);
		
	}
	
	public void run() {
		String name = "";
		try {
			name = i.readLine();
			ChatServer.list.add("#"+name);
			server.register(this);
			broadcast(name+"¥‘¿Ã πÊπÆ«œºÃΩ¿¥œ¥Ÿ.");
			while(true) {
				String msg = i.readLine();
				broadcast(name+" - "+msg);
				
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		server.unregister(this);
		ChatServer.list.remove(ChatServer.list.indexOf((String)name));
		broadcast(name+"¥‘¿Ã ≥™∞°ºÃΩ¿¥œ¥Ÿ.");
		try {
			i.close();
			o.close();
			s.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	protected void println(String message) {
		o.println(message);
	}
	protected void broadcast(String message) {
		server.broadcast(message);
	}
	
}
