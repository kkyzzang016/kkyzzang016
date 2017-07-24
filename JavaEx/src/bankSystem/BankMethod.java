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

	Vector<BankClientInfo> client = new Vector<BankClientInfo>();
	Vector<String> totalid = new Vector<String>();
	String curID="";
	FileReader reader;
	FileWriter fw;
	BufferedWriter bw;
	PrintWriter pw;
	File file = new File("C:\\Users\\odae\\Desktop\\Git\\kkyzzang016\\JavaEx\\src\\bankSystem\\BankClient.txt");
	StringTokenizer st;
	StringTokenizer stf;

	//생성자
	public BankMethod() {
		String temp=in();
		firstIn(temp);
	}
	//보내기
	public void out(String str) {
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);

			pw.append(str + "\n");
			pw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	//가져오기
	public String in() {
		String aa = "";
		try {
			reader = new FileReader(file);
			while (reader.ready()) {
				char ch = (char) reader.read();
				aa += Character.toString(ch);
			}
			reader.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return aa;
	}
	//입력값 붙임
	public String addString(String id, String pw, String name, String account, String phone, String birth) {
		String result = id + "#" + pw + "#" + name + "#" + account + "#" + phone + "#" + birth;
		return result;
	}
	//입력값 붙임#2
	public String addString(String str1, String str2, String str3) {
		String result = str1 + str2 + str3;
		return result;
	}
	//parsing
	public void firstIn(String str){
		stf = new StringTokenizer(str,"\n");
		int size = stf.countTokens();
		
		for(int i=0;i<size;i++){
			clientIn(stf.nextToken());
		}
	}
	//계좌번호 생성
	public String accMake(){
		String str = String.valueOf((Math.random()*100));
		return str;
	}
	//신규고객 생성시 호출
	public void clientIn(String str) {
		BankClientInfo bi = new BankClientInfo();
		st = new StringTokenizer(str, "#");
		int size = st.countTokens();
		for (int i = 0; i < size; i++) {
			switch (i) {
				case 0:
					String token = st.nextToken();
					bi.setId(token);
					totalid.add(token);
					break;
	
				case 1:
					bi.setPw(st.nextToken());
					break;
	
				case 2:
					bi.setName(st.nextToken());
					break;
	
				case 3:
					bi.setAccount(st.nextToken());
					break;
	
				case 4:
					bi.setPhone(st.nextToken());
					break;
	
				case 5:
					bi.setBirth(st.nextToken());
					break;
				
				default: System.out.println("오류임마");
					break;
			}
		}
		client.add(bi);
	}
	
	//중복체크
	public boolean confirm(String str){
		
		boolean flag = false;
		for(int i=0;i<totalid.size();i++){
			if(totalid.contains(str)){
				flag=false;
			}
			else flag=true;
		}
		return flag;
	}

	//로그인
	public boolean login(String id, String pw) {
		
		String tid="";
		int index=0;
		boolean flag=false;
		
		for(int i=0;i<client.size();i++) {
			String temp = String.valueOf(client.get(i).getId());
			if(temp.equals(id)) {
				tid=id;
				index=i;
			}
			else {
				flag=false;
			}
		}
		
		
		return flag;
	}
}
