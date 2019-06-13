/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: InstanceHolder.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread;

public class InstanceHolder {


	
	public static Instance instance=new Instance();
	
		public InstanceHolder(){
			System.out.println("init InstanceHolder3");
		}
}
