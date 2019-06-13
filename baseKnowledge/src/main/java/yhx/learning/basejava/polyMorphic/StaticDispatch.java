/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: StaticDispatch.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.polyMorphic;

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
