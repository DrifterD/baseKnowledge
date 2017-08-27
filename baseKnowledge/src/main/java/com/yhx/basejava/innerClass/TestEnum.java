package com.yhx.basejava.innerClass;

public enum TestEnum {

	test(1,"test"),
	
	test2(2,"测试2");
	
	private String str;
	private int code ;
	
	TestEnum(int code, String str){
		this.code=code;
		this.str=str;
	}
	
	public void test(){
		System.out.println("enum");
	}
	
	public static void main(String[] args){
		TestEnum.test2.test();
	}
}
