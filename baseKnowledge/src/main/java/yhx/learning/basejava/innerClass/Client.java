/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: Client.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.innerClass;

public class Client {

	public static void main(String[] args) {
		Person p=new Person("tom");
		p.clothes(" red ", " t-shirt");
		
		Super super1=new Sub(222);
		
		super1.testMethod();
		Test test = new Test();
	}

}
