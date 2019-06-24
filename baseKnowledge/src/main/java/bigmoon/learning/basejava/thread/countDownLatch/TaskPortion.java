/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: TaskPortion.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {

	private static Random random=new Random(400);
	private CountDownLatch cdl;
	private static int count=0;
	private final int id=count++;
	
	public TaskPortion(CountDownLatch cdl){
		this.cdl=cdl;
	}
	public void run(){
		
		try {
			TimeUnit.MILLISECONDS.sleep(500);
			System.out.println("Thread "+id+" completed");
			cdl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
