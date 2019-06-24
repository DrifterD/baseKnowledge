/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Super.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.innerClass;

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
