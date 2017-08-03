package com.javalec.ex;

public class Calculation {

	public void add(int i, int s) {
		System.out.println("add()");
		System.out.println(i+" + "+s+" = "+(i+s));
	}
	public void sub(int i, int s) {
		System.out.println("sub()");
		System.out.println(i+" - "+s+" = "+(i-s));
	}
	public void multi(int i, int s) {
		System.out.println("multi()");
		System.out.println(i+" * "+s+" = "+(i*s));
	}
	public void div(int i, int s) {
		System.out.println("div()");
		System.out.println(i+" / "+s+" = "+(i/s));
	}
}
