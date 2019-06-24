/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Accessor.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.threadlocal;

public class Accessor implements Runnable{

	private Integer incr;
	
	public Accessor(Integer incr){
		this.incr=incr;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			
			MainClient.increment();
			System.out.println(this);
			Thread.yield();		
		}
		
	}
	
	public String toString(){
		return ("threadName= "+Thread.currentThread().getName() +",incr="+this.incr+" ;"+MainClient.get());
	}

}
