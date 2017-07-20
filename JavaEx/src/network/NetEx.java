package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * ��Ʈ��ũ(network)
 * 
 * 1. ip�ּ� : ���ͳ� �󿡼��� �� ��ǻ�͵��� �ν��ϱ� ���� �ο��� ������ ��
 * 0~255������ ���� ���� ����(�̰��� Octet�̶� �մϴ�) 4���� ����(�����̷� ������ Ipv4��� �մϴ�)�ؼ� ����ϴ�.
 * ���ڸ����� �� �ּҴ� �ܿ�Ⱑ ���� �ϻ������� �� �� �ִ� ���������� �ּҸ� ����� ���� ������(domain)�̶� �մϴ�.
 * 
 * ��) ip : 220.95.223.8			������ : empas.com 			ȣ��Ʈ : www.empas.com
 * 
 * 
 * 2 ��Ʈ(port)
 * ip�ּҰ� ���ͳ� �󿡼� ��ǻ�͵鿡�� �ο��� �ּҶ��,
 * ��Ʈ�� �� ��ǻ�ͳ����� �� ���α׷�(���μ���)���� �Ҵ� �� ��ȣ��� �� �� �ְڽ��ϴ�.
 * ��ǻ�ʹ� �� ��û�� ��Ʈ ��ȣ�� �ٶ� ����� ���μ����� ������� �ִ� ���Դϴ�.
 * �ٸ��� ���ϸ�, �ϳ��� ��Ʈ�� ���� ���α׷�(���μ���)�� ���� �� �� �����ϴ�.
 * ip�ּҰ� �����п��̶��, ��Ʈ�� ���ǽ� 201ȣ Ȥ�� 202ȣ��� �� �� �ֽ��ϴ�.
 * 	��Ʈ�� 0������ 65535������ 16��Ʈ ������ ���¸� �����ϴ�.
 * �밳 0~1024������ �ý����̳� ���� ���񽺿��� ����ϴ� ��Ʈ�̰� 1024�̻��� ��Ʈ�� �츮�� ���Ƿ� ���ŵ� �����ϴ�.
 * 
 * 
 * 3. �������� : ��űԾ� !!!!!
 * 
 * TCP - �������� �������� / ��� ��ȣ���� ���ӿ� ���� ������ �̷������ �����Դϴ�.
 * 			�ڹٴ� TCP����� Ŭ���̾�Ʈ ���� ����� ���� ServerSocket, Socket Ŭ������ �����մϴ�.
 * 
 * UDP - ��� ��ȣ���� ���ӿ� ���� �������� �����͸� �����ϴ� ����Դϴ�.
 * 			�����ڴ� �Ϲ������� �����ڿ��� ������ �����ڴ� �����Ͱ�
 * 			������������ ��ä ���� ��ٸ��� �ֽ��ϴ�.
 * 			�ڹٿ��� UDP��� ����� ���� DatagramPacket, DatagramSocket Ŭ������ �����մϴ�.
 * 
 * 
 * 4. ����(Socket)�̶� ��Ʈ��ũ ���� ��ȣ ȣ��Ʈ�� ����� ���� ������ �ǹ��մϴ�.
 * 
 * -����
 * ȣ��Ʈ�� ����� �ϱ� ���ؼ��� ����� �ּ�(IP)�� ��Ʈ(port)�� �ʿ��ϸ�,
 * �ּҿ� ��Ʈ�� �̿��ؼ� ������ ������ �� �ֽ��ϴ�.
 * 
 * Ex) Socket socket = new Socket(host,port);
 * ServerSocket server = new ServerSocket(port);
 * 
 * -���� : Ŀ�ؼ�(connection)�� ����
 * 
 * 
 * 5. java.net.InetAddress class - IP�ּҸ� ��ü �𵨸��� Ŭ����
 */
public class NetEx {

	public static void main(String[] args)	throws UnknownHostException {
		InetAddress addr1 = InetAddress.getByName("www.naver.com");
		InetAddress addr2 = InetAddress.getLocalHost();
		System.out.println("==========================");
		System.out.println("Ip - "+addr1.getHostAddress());
		System.out.println("Host = "+addr1.getHostName());
		System.out.println("���� �ּ� = "+addr2.getHostAddress());
		System.out.println("���� �̸� = "+addr2.getHostName());
	}
}