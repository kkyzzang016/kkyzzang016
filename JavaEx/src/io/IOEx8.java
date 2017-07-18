package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOEx8 {
	public static void main(String[] args) throws IOException{
		
		File file = new File("C:/Users/odae/Desktop/Git/kkyzzang016/JavaEx/src/io/IOEx5_sample.txt");		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw,true);		//�����÷��� flush()
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�Է� :");
		String str = "";
		while(!str.equals("end")) {
			str = in.readLine();
			pw.println(str);
		}
		in.close();
		pw.close();
	}
}
