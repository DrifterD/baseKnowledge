package com.yhx.basejava.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class threadPoolMain {

	public static void main(String[] args) {
		BlockingQueue<Runnable> blockQun = new ArrayBlockingQueue<Runnable>(100);
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 12, 80, TimeUnit.SECONDS, blockQun);
		
		for (int i = 0; i < 100; i++) {
			tpe.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "a thread run");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}
