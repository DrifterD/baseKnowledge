/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Client.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.innerClass;

public class Client {

	public static void main(String[] args) {
		Person p=new Person("tom");
		p.clothes(" red ", " t-shirt");
		
		Super super1=new Sub(222);
		
		super1.testMethod();
		Test test = new Test();
	}

}
