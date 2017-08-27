package com.yhx.basejava.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {

	static boolean flag = true;
	static Object lock = new Object();

	public static void main(String[] args) {

		Thread wait=new Thread(new Wait(),"waitThread");
		Thread notify=new Thread(new Notify(),"notifyThread");
		wait.start();
		SleepUtils.second(1);
		notify.start();
		
	}

	static class Wait implements Runnable {

		/*
		 * 等待方（消费方） 经典模式
		 * 
		 * synchronized(lock){
		 *     while(flag){
		 *         wait();
		 *     }
		 *     //
		 *     dosomething();
		 *   }
		 * 
		 * */
		
		@Override
		public void run() {

			synchronized (lock) {

				while (flag) {
					try {
						// 不符合条件， 等待
						System.out.println(Thread.currentThread().getName() + " flag is "+flag+" , wait"
								+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException ex) {

					}
				}

				// 滿足條件，完成工作
				System.out.println(Thread.currentThread().getName() + " flag is  "+flag+" , running"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}

	static class Notify implements Runnable {
		
		/*
		 * 通知方(生产方) 经典模式 
		 * 
		 * synchronized(lock){
		 * 		改变flag条件
		 * 	    lock.notifyAll();
		 * }
		 * */
		
		@Override
		public void run() {
			
			synchronized(lock){
				
				System.out.println(Thread.currentThread().getName() + " hold lock. notify"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				
				lock.notifyAll();
				//flag=false;
				SleepUtils.second(4);				
			}
			
			synchronized(lock){
				System.out.println(Thread.currentThread().getName() + " hold lock. again sleep"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(4);	
			}
			
		}

	}

}
