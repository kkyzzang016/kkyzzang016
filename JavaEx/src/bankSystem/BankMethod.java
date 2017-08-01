package bankSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class BankMethod {

	public static Vector<BankClientInfo> client = new Vector<BankClientInfo>();
	public static int insertnum=1;
	BankDB bd = new BankDB();
	
	//회원가입 시 중복체크 메소드
	public boolean idConfirm(String str) { 
		boolean flag = false;
		for(int i=0;i<BankMethod.client.size();i++) {
			String tempid = String.valueOf(BankMethod.client.get(i).getId());
			if(tempid.equals(str)) {
				flag=false;
				break;
			}
			else flag =true;
		}
		return flag;
	}
	
	//클라이언트 추가1
	public void newClient(String id, String pw, String name, String add, String add1, String account, 
													String phone1, String phone2, String phone3, String birth) { 
		
		String address = add+add1;
		String phone = phone1+phone2+phone3;
		BankClientInfo bi = new BankClientInfo(id, pw, name, address, account, phone, birth);
		client.add(bi);
		bd.insertCilentData(bi, insertnum);
	}
	
	//클라이언트 추가2
	public void newClient(String id, String pw, String name, String address, String account, 
			String phone, String birth) { 

		BankClientInfo bi = new BankClientInfo(id, pw, name, address, account, phone, birth);
		client.add(bi);
		bd.insertCilentData(bi, insertnum);
	}
	
	//계좌번호 생성
	public String makeAccount() { 
		String temp = null;
		for(int i=0;i<client.size()+1;i++) {
			temp = String.valueOf((int)(Math.random()*10000)+1);
			for(int j=0;j<i;j++) {
				if(client.get(j).getAccount().equals(temp))	i--;
			}
		}
		return temp;
	}
	
	//프로그램 시작
	public void start() {		
		bd.initCilentData();
		new BankLoginUI();
	}
	
	//로그인 메소드
	public boolean login(String id, String pw) { 
		boolean flag = false;
		String realid;
		String realpw;
		for(int i=0;i<client.size();i++) {
			realid = client.get(i).getId();
			realpw = client.get(i).getPw();
			if(realid.equals(id)&&realpw.equals(pw)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
