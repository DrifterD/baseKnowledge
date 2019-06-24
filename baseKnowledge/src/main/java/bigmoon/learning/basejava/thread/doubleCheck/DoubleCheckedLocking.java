/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: DoubleCheckedLocking.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.doubleCheck;

public class DoubleCheckedLocking {

	private static Instance instance;
	
	public static Instance getInstance(){
		
		if(instance==null){
			
			synchronized(DoubleCheckedLocking.class){				
				if(instance==null)
					instance=new Instance();	
			}	
		}
		
		return instance;
	}
	
	public static void main(String[] args){
		
		for(int i=0;i<200;i++){
			Thread t1=new Thread(new Runnable(){

				public void run() {			
					System.out.println(Thread.currentThread().getName()+"  has done, name="+DoubleCheckedLocking.getInstance().getName());
				}
			});
			t1.setName("t"+i);
			t1.start();
		}
	}	
}
