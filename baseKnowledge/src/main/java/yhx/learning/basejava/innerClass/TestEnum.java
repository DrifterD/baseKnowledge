/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: TestEnum.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.innerClass;

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
