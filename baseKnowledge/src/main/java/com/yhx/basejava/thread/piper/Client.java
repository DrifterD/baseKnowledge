package com.yhx.basejava.thread.piper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Sender sender=new Sender();
		Reciver reciver=new Reciver(sender);
		
		ExecutorService excoter=Executors.newCachedThreadPool();
		excoter.execute(sender);
		excoter.execute(reciver);
		TimeUnit.SECONDS.sleep(10);
		excoter.shutdown();
	}

}
