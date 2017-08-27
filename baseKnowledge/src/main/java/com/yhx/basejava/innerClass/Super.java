package com.yhx.basejava.innerClass;

public abstract class Super {

	public int field=0;
	
	public int getField(){return this.field;}
	
	public Super(){
		System.out.print("abstract class constractor");
	}
	
	public void testMethod(){
		System.out.println("Super method");
	}
	
	public Super(int i ){
		System.out.println("abstract sinsti super"+i);
	}
}
