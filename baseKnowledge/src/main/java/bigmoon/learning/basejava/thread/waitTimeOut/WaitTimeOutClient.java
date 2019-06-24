/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: WaitTimeOutClient.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.waitTimeOut;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitTimeOutClient {

	private static ConnectionPool pool = new ConnectionPool(10);
	private static CountDownLatch start = new CountDownLatch(1);
	private static CountDownLatch end;
	private static int count=20;
	static AtomicInteger got=new AtomicInteger(0);
	static AtomicInteger notGot=new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {		
		
		int threadCount=30;
		end=new CountDownLatch(threadCount);
		
		for(int i=0;i<threadCount;i++){
			Thread t=new Thread(new ConnectionRunner(count,got,notGot),i+"");
			t.start();
		}
		
		start.countDown();
		end.await();
		System.out.println("total invoke :"+(threadCount*count));
		System.out.println("got invoke :"+got);
		System.out.println("not got invoke :"+notGot);
		
	}

	static class ConnectionRunner implements Runnable {

		int count;
		AtomicInteger got;
		AtomicInteger notGot;

		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {

			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}

		@Override
		public void run() {

			try {
				start.wait();
			} catch (Exception ex) {

			}

			while (count > 0) {

				try {

					Connection con = pool.fetchConnection(1000);

					if (null != con) {
						try {
							con.createStatement();
							con.commit();
						} finally {
							pool.releaseConnection(con);
							got.incrementAndGet();
						}
					} else {
						this.notGot.incrementAndGet();
					}

				} catch (Exception ex) {

				} finally {
					count--;
				}
			}
			end.countDown();
		}
	}

}
