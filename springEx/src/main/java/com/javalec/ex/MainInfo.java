package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainInfo {
	public static void main(String[] args) {
		String config1 = "classpath:application.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config1);
		MyInfo myinfo = ctx.getBean("myinfo", MyInfo.class);
		
		myinfo.getInfo();
		ctx.close();
	
	}
}
