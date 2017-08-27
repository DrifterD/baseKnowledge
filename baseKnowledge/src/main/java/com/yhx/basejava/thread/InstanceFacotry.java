package com.yhx.basejava.thread;

public class InstanceFacotry {

	//public  static Instance instance = new Instance();
	public  static Instance instance = null;
	static {
		 System.out.println("init static InstanceFacotry 1");		
	}
	
	public InstanceFacotry(){
		 System.out.println("init InstanceFacotry 2");		
	}
	public static Instance getInstance(){
		return InstanceHolder.instance;
	}
	
	public static Instance getInstance2(){
		return instance;
	}
	
	public static Instance getMyInstance(){
		return instance;
	}
}
