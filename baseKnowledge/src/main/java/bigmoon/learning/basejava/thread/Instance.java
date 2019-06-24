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

package bigmoon.learning.basejava.thread;


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
