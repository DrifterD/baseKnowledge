/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: threadPoolMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class threadPoolMain {

	public static void main(String[] args) {
		BlockingQueue<Runnable> blockQun = new ArrayBlockingQueue<Runnable>(5);
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 12, 80, TimeUnit.SECONDS, blockQun);
		
		for (int i = 0; i < 10; i++) {
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

		tpe.shutdown();
		while(!tpe.isTerminated()){
//			System.out.println("线程池需要执行的任务"+tpe.getTaskCount());
//			System.out.println("线程池需要执行的任务"+tpe.getCompletedTaskCount());
//			System.out.println("线程池需曾经最大量"+tpe.getLargestPoolSize());
		}

		System.out.println("线程池需要执行的任务"+tpe.getTaskCount());
		System.out.println("线程池完成的任务"+tpe.getCompletedTaskCount());
		System.out.println("线程池需曾经最大量"+tpe.getLargestPoolSize());

		System.out.println("线程池完成咯");


	}
}
