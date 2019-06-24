/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: JoinThread.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread;

public class JoinThread {

	static class Demo implements Runnable{
		private Thread prvoies;
		
		public Demo(Thread provies){
			this.prvoies=provies;
		}
		
		public void run(){				
			try {
				this.prvoies.join(300);
				System.out.println(Thread.currentThread().getName() +" terminate");
				Thread.sleep(500);	
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
	}
	
	public static void main(String[] args) {

		Thread pro=Thread.currentThread();
		
		for(int i=0;i<10;i++){
			
			Thread tmpT=new Thread(new Demo(pro),i+"");
			tmpT.start();
			pro=tmpT;			
		}
		
		System.out.println(Thread.currentThread().getName() +" terminate");
	}

}
