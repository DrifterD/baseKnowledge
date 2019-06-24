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

package bigmoon.learning.basejava.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class Client {

	public static void main(String[] args) {
		int size=10;
		int maxSize=20;
		
		
		CountDownLatch cdl=new CountDownLatch(size);
		ExecutorService executor=Executors.newCachedThreadPool();
		
		for(int i=0;i<size;i++){
			executor.execute(new WaitTask(cdl));
			executor.execute(new TaskPortion(cdl));
		}

	}

}
