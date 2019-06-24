/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Instance.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.doubleCheck;

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
