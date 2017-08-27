package com.yhx.basejava.thread.countDownLatch;

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
