package com.yhx.basejava.thread;


public class Instance{
	public static String name="";
	
	
	
	static{
		
			 System.out.println("static init Instance1");			
	}
	
	{
		 System.out.println("init Instance2");
	}
	
	public Instance(){
		System.out.println("init construct instance");
	}
	
	public static void testMethod(){
		System.out.println("invoke static method");
	}
}
