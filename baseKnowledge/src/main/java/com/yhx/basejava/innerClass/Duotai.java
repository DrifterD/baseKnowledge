package com.yhx.basejava.innerClass;

//多态
public class Duotai {

	
	//对域的访问，没有多台态
	public static void main(String[] args){
		Sub superOb=new Sub();
		System.out.println(superOb.testMethod("22"));
		superOb.testMethod(22);
		Object cn= new Object();
		System.out.print(superOb.testMethod(cn));
	}
	
}
