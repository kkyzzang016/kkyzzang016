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

	public EchoServer(int port) throws IOException{ //생성자로 통신도구(소켓) 생성
		server = new ServerSocket(port);
	}
	
	public void service() throws IOException{
		System.out.println("EchoServer is ready.");
		
		Socket client = server.accept();					  //클라이언트 요청 대기 / 실행중인 블락상태가 된다
		
		InputStream is = client.getInputStream();	  // 연결되면 서버와 클라이언트 모두 IO준비  /  보내고 받기위해 Input Output 모두 쓴다.
		OutputStream os = client.getOutputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		PrintWriter out = new PrintWriter(os,true);
		
		while(true) {
			String msg = in.readLine(); 		//클라이언트 입력대기
			System.out.println(msg);
			if(msg.equals("bye")) {
				break;
			}
			out.println(">>"+msg);			//클라이언트에 msg전송
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
