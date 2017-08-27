package com.yhx.basejava.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	static ExecutorService threadPool = Executors.newFixedThreadPool(30);

	public static void main(String[] args) {

		final Semaphore sp = new Semaphore(10);
		for (int i = 0; i < 30; i++) {

			threadPool.execute(new Runnable() {

				public void run() {
					
					System.out.println("therad has come in this method");

					try {
						sp.acquire();
						TimeUnit.SECONDS.sleep(3);
						
						System.out.println("therad has come in this method,await count=" + sp.getQueueLength()
								+ ", availablePermits=" + sp.availablePermits());
						sp.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			});
		}
		System.out.println("foreach is over");
		threadPool.shutdown();
	}

}
