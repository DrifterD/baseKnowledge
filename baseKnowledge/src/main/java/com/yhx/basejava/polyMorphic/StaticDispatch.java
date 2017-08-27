package com.yhx.basejava.polyMorphic;

//方法金泰分配演示
public class StaticDispatch {

	static abstract class Human{}
	
	static class Man extends Human{}
	
	static class Woman extends Human{}
	
	public void sayHello(Human guy){
		System.out.println("hello ,guys");
	}
	
	public void sayHello(Man guy){
		System.out.println("hello ,Man");
	}
	
	public void sayHello(Woman guy){
		System.out.println("hello ,woman");
	}
	
	public static void main(String[] args){
		StaticDispatch sd=new StaticDispatch();
		Human man=new Man();
		Human woman=new Woman();
		sd.sayHello(man);
		sd.sayHello(woman);
	}
}
