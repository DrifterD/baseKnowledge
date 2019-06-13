/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: InstanceFacotry.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread;

public class InstanceFacotry {

	//public  static Instance instance = new Instance();
	public  static Instance instance = null;
	static {
		 System.out.println("init static InstanceFacotry 1");		
	}
	
	public InstanceFacotry(){
		 System.out.println("init InstanceFacotry 2");		
	}
	public static Instance getInstance(){
		return InstanceHolder.instance;
	}
	
	public static Instance getInstance2(){
		return instance;
	}
	
	public static Instance getMyInstance(){
		return instance;
	}
}
