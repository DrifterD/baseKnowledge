package com.yhx.basejava.thread.doubleCheck;

public class Instance {

	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	static{
		System.out.println("static code ");
	}
	
	public Instance(){
		this.name="test name";
		this.age=18;
		System.out.println(Thread.currentThread().getName()+", constract");
	}
	
}
