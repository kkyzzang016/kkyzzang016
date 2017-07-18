package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx6 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fw = new FileOutputStream(new File("C:/Users/odae/Desktop/Git/kkyzzang016/JavaEx/src/io/IOEx5_sample.txt"));
		
		System.out.println("ÀÔ·Â");
		int abc = 0;
		while(abc != -1) { // -1Àº ctrl + z
			abc = System.in.read();
			fw.write(abc);
		}
		fw.close();
	}
}
