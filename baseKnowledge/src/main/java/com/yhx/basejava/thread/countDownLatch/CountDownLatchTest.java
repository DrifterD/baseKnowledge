package com.yhx.basejava.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch  cdl=new CountDownLatch(4);
		
		Thread t=new Thread(new Runnable(){

			public void run() {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("start pringt 1");
				cdl.countDown();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("start pringt 2");
				cdl.countDown();
			}			
		});
		
		Thread t2=new Thread(new Runnable(){

			public void run() {
				System.out.println("start pringt 4");
				cdl.countDown();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("start pringt 5");
				cdl.countDown();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		t2.start();
		t.start();
		System.out.println("main thread wait the result");
		cdl.await();
		System.out.println("3");

	}

}
