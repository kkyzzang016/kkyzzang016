package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 네트워크(network)
 * 
 * 1. ip주소 : 인터네 상에서의 각 컴퓨터들을 인식하기 위해 부여된 유일의 값
 * 0~255사이의 값을 가진 숫자(이것을 Octet이라 합니다) 4개를 조합(현재이런 조합은 Ipv4라고 합니다)해서 만듭니다.
 * 숫자만으로 된 주소는 외우기가 힘들어서 일상적으로 알 수 있는 문자형태의 주소를 만드는 것을 도메인(domain)이라 합니다.
 * 
 * 예) ip : 220.95.223.8			도메인 : empas.com 			호스트 : www.empas.com
 * 
 * 
 * 2 포트(port)
 * ip주소가 인터넷 상에서 컴퓨터들에게 부여된 주소라면,
 * 포트는 한 컴퓨터내에서 각 프로그램(프로세스)에게 할당 된 번호라고 할 수 있겠습니다.
 * 컴퓨터는 이 요청된 포트 번호에 다라 담당할 프로세스로 연결시켜 주는 것입니다.
 * 다르게 말하면, 하나의 포트를 여러 프로그램(프로세스)이 공유 할 수 없습니다.
 * ip주소가 강남학원이라면, 포트는 강의실 201호 혹은 202호라고 할 수 있습니다.
 * 	포트는 0번에서 65535번까지 16비트 정수의 형태를 가집니다.
 * 대개 0~1024까지는 시스템이나 기존 서비스에서 사용하는 포트이고 1024이상의 포트는 우리가 임의로 쓰셔도 좋습니다.
 * 
 * 
 * 3. 프로토콜 : 통신규약 !!!!!
 * 
 * TCP - 접속지향 프로토콜 / 통신 상호간에 접속에 대한 설정이 이루어지기 때문입니다.
 * 			자바는 TCP기반의 클라이언트 서버 통신을 위해 ServerSocket, Socket 클래스를 제공합니다.
 * 
 * UDP - 통신 상호간에 접속에 대한 설정없이 데이터를 전송하는 방식입니다.
 * 			전송자는 일방적으로 수신자에게 보내고 수신자는 데이터가
 * 			언제오는지도 모른채 마냥 기다리고 있습니다.
 * 			자바에선 UDP기반 통신을 위해 DatagramPacket, DatagramSocket 클래스를 제공합니다.
 * 
 * 
 * 4. 소켓(Socket)이란 네트워크 상의 상호 호스트간 통신을 위한 도구를 의미합니다.
 * 
 * -생성
 * 호스트간 통신을 하기 위해서는 상대의 주소(IP)와 포트(port)가 필요하며,
 * 주소와 포트를 이용해서 소켓을 개설할 수 있습니다.
 * 
 * Ex) Socket socket = new Socket(host,port);
 * ServerSocket server = new ServerSocket(port);
 * 
 * -역할 : 커넥션(connection)의 유지
 * 
 * 
 * 5. java.net.InetAddress class - IP주소를 객체 모델링한 클래스
 */
public class NetEx {

	public static void main(String[] args)	throws UnknownHostException {
		InetAddress addr1 = InetAddress.getByName("www.naver.com");
		InetAddress addr2 = InetAddress.getLocalHost();
		System.out.println("==========================");
		System.out.println("Ip - "+addr1.getHostAddress());
		System.out.println("Host = "+addr1.getHostName());
		System.out.println("로컬 주소 = "+addr2.getHostAddress());
		System.out.println("로컬 이름 = "+addr2.getHostName());
	}
}