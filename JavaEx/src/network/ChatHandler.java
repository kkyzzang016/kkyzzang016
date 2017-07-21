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
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;

public class ChatHandler extends Thread {

	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer server;
	private StringTokenizer st;

	public ChatHandler(ChatServer server, Socket s) throws IOException {

		this.s = s;
		this.server = server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i = new BufferedReader(new InputStreamReader(ins));
		o = new PrintWriter(new OutputStreamWriter(os), true);

	}

	public void run() {
		String name = "";
		
		try {
				while (true) {
					String code="";
					String message="";
					String msg = i.readLine();
					
					st = new StringTokenizer(msg, "|",false);
					int su = st.countTokens();
	
					code=st.nextToken();
					message =st.nextToken();
	
					switch(code) {
						case "100":
							System.out.println(100);
							ChatServer.list.add("#" + message);
							name=message;
							server.register(this);
							broadcast(message + "¥‘¿Ã πÊπÆ«œºÃΩ¿¥œ¥Ÿ.");
							break;
							
						case "200":
							System.out.println(200);
							broadcast(name + " - " + message);
							break;
							
						case "300":
							System.out.println(300);
							ChatServer.list.remove("#" + name);
							server.unregister(this);
							broadcast(name + "¥‘¿Ã ≥™∞°ºÃΩ¿¥œ¥Ÿ.");
							break;
							
						default :
							System.out.println("err");
							break;
					}
			}
				
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		ChatServer.list.remove("#" + name);
		server.unregister(this);
		broadcast(name + "¥‘¿Ã ≥™∞°ºÃΩ¿¥œ¥Ÿ.");
		try {
			i.close();
			o.close();
			s.close();
		} catch (IOException ex) {
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
