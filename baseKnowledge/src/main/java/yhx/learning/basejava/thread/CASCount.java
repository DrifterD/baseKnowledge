/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: CASCount.java
 * Author:   yhx
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-6-13 上午11:19      版本号        描述
 */

package yhx.learning.basejava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CASCount {

	private AtomicInteger atomictI=new AtomicInteger(0);
	private int i=0;
	
	private void safeCount(){
		for(;;){
			int i=atomictI.get();
			boolean suc=atomictI.compareAndSet(i, ++i);
			
			if(suc){
				break;
			}			
		}
	}
	
	private void count(){
		i++;
	}
	
	public static void main(String[] args) {
		
		final CASCount count=new CASCount();
		
		List<Thread> ts=new ArrayList<Thread>();
		
		long start=System.currentTimeMillis();
		
		for(int i=0;i<100;i++){
			Thread t=new Thread(new Runnable(){

				public void run() {
					for(int i=0;i<10000;i++){
						count.safeCount();
						count.count();
					}					
				}
				
				
			});
			
			ts.add(t);
		}
		
		for(Thread tmpT:ts){
			tmpT.start();
		}
		
		for(Thread tmpT:ts){
			try {
				tmpT.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(count.i+"");
		System.out.println(count.atomictI.get());
		System.out.println(System.currentTimeMillis()-start);
	}
}
