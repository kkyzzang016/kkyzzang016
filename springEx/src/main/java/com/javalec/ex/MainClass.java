package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*MyCalculator mc = new MyCalculator();
		mc.setCal(new Calculation());

		mc.setFirstNum(10);
		mc.setSecondNum(2);

		mc.add();
		mc.sub();
		mc.multi();
		mc.div();*/
		
		String config = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		MyCalculator mc = ctx.getBean("mc", MyCalculator.class);
		
		mc.add();
		mc.sub();
		mc.multi();
		mc.div();
	}
}
