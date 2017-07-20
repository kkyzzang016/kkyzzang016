package network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class ChatServer {
private Vector handlers;
static Vector<String> list = new Vector<String>();
	public ChatServer(int port) {
		try{
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector();
			System.out.println("CharServer is ready.");
			while(true) {
				Socket client  = server.accept();
				ChatHandler c = new ChatHandler(this,client);
				c.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}
	public void register(ChatHandler c) {
		handlers.addElement(c);
	}
	public void unregister(Object o) {
		handlers.removeElement(o);
	}
	
	public void broadcast(String message) {
		synchronized (handlers) {
			int n = handlers.size();
			
			for(int i=0;i<n;i++) {
				ChatHandler c = (ChatHandler) handlers.elementAt(i);
				String temp="";
				try {
					Iterator it = list.iterator();
					while(it.hasNext()) {
						temp += (String)it.next();
					}
					c.println(message+temp);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer(9830);
	}
}
