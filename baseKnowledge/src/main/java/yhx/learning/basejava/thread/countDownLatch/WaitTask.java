/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: WaitTask.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class WaitTask implements Runnable{
	
	private static int count=0;
    private final int id=count++;
	private CountDownLatch cdl;
	
	public WaitTask(CountDownLatch cdl){
		this.cdl=cdl;		
	}
	
	public void run(){
		
		try {
			this.cdl.await();
			System.out.println(String.format("wait thread %s has completed",id));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
