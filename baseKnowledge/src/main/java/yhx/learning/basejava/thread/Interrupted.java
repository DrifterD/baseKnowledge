/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: Interrupted.java
 * Author:   yhx
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-6-13 上午11:18      版本号        描述
 */

package yhx.learning.basejava.thread;

/**
 * 线程中断理解.线程中断是一个
 *
 * **/
public class Interrupted {

	static class SleepRunner implements Runnable{

		public void run() {
			while(true){
				//SleepUtils.second(10);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}		
	}
	
	static class BusyRunner implements Runnable{

		public void run() {
			while(true){
				
			}
			
		}		
	}
	
	public static void main(String[] args){
		Thread sleepThread=new Thread(new SleepRunner(),"sleep");
		Thread busyThread=new Thread(new BusyRunner(),"BusyRunner");
		sleepThread.setDaemon(true);
		busyThread.setDaemon(true);
		sleepThread.start();
		busyThread.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sleepThread.interrupt();
		busyThread.interrupt();
		System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is busyThread.isInterrupted(),Thread.isInterrupted:"+Thread.interrupted());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
