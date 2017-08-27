package com.yhx.basejava.innerClass;

public class Client {

	public static void main(String[] args) {
		Person p=new Person("tom");
		p.clothes(" red ", " t-shirt");
		
		Super super1=new Sub(222);
		
		super1.testMethod();
		
	}

}
