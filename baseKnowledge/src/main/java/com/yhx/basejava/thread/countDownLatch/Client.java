package com.yhx.basejava.thread.countDownLatch;

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
