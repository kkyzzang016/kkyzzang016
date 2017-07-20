package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
private ServerSocket server;

	public EchoServer(int port) throws IOException{ //�����ڷ� ��ŵ���(����) ����
		server = new ServerSocket(port);
	}
	
	public void service() throws IOException{
		System.out.println("EchoServer is ready.");
		
		Socket client = server.accept();					  //Ŭ���̾�Ʈ ��û ��� / �������� ������°� �ȴ�
		
		InputStream is = client.getInputStream();	  // ����Ǹ� ������ Ŭ���̾�Ʈ ��� IO�غ�  /  ������ �ޱ����� Input Output ��� ����.
		OutputStream os = client.getOutputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		PrintWriter out = new PrintWriter(os,true);
		
		while(true) {
			String msg = in.readLine(); 		//Ŭ���̾�Ʈ �Է´��
			System.out.println(msg);
			if(msg.equals("bye")) {
				break;
			}
			out.println(">>"+msg);			//Ŭ���̾�Ʈ�� msg����
		}
	}
	
	public void close() throws IOException{
		server.close();
	}
	public static void main(String[] args) {
		
		try {
			EchoServer es = new EchoServer(1289);
			es.service();
			es.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
