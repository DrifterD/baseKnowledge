/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: Sub.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.innerClass;

import java.util.List;

public class Sub extends Super {

	public Sub(int i2){
		super(i2);
	}
	
	public Sub(){
		super(0);
	}
	public int field=1;
	
	public int getField(){return this.field;}
	
	public int getSuperField(){return super.field;}
	
	public void testMethod(){
		System.out.println("sub method");
	}
	
	public void testMethod(Integer i){
		System.out.println("sub overload method");
	}
	
	public String testMethod(Object t){
		return t+",number";
	}
	
	public String testMethod(CharSequence cs){
		return cs.toString();
	}
	
	
	public void testOverLoading(List<String> strings){
		System.out.println("list str");
	}
	
	public void testOverLoading(List<Integer> strings,int u){
		System.out.println("list str");
	}
	
	public static void testMethod2(){
		System.out.println("sub method 2");
	}
	
}
