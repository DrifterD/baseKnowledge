/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: BankWaterServer.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.cyclicBarrier;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankWaterServer implements Runnable {

	private CyclicBarrier cb=new CyclicBarrier(4,this);
	private Map<String,Integer> maps=new HashMap<String,Integer>();
	
	public void testCyclicBarrier(){
		
		ExecutorService es=Executors.newCachedThreadPool();
		
		for(int i=0;i<12;i++){
		es.execute(new Runnable(){
			
			public void run(){		
			
				maps.put(Thread.currentThread().getName(),1);	
				System.out.println("++count");
				try {
					System.out.println("task has completed,will be wait");
					cb.await();
					System.out.println(Thread.currentThread().getName()+"over");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		};
		
	}
	
	
	public void run() {
		
		System.out.println("come in");
		Integer count=0;
		for(Entry<String,Integer> entry:maps.entrySet()){
			count=entry.getValue()+count;
			
		}
		
		System.out.println("all :"+count);
		
		//reset 方法在CycriyBarrier 都等待通过时，reset方法会重置并且报错BrokenBarrierException
		/*try {
			cb.reset();
		} catch (BrokenBarrierException e) {
			System.out.println("reset count");
			e.printStackTrace();
		}*/
	}

}
