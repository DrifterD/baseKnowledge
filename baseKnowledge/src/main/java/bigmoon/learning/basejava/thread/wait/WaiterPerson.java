/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: WaiterPerson.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.wait;

public class WaiterPerson implements Runnable{

	private Resetorantor resetorantor;
	
	public WaiterPerson(Resetorantor resetorantor){
		this.resetorantor=resetorantor;
	}
	
	public void run() {
		try {
		while(!Thread.interrupted()){
			
			synchronized(this.resetorantor){
				
				while(this.resetorantor.meal.getOrderNumber()==0){
					
						this.resetorantor.wait();
				
				}
				
				//有菜，需要上菜
				this.resetorantor.meal.setOrderNumber(0);
				System.out.println(Thread.currentThread().getName()+",上菜咯");
				//this.resetorantor.notify();
				this.resetorantor.notifyAll();
			}
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("wait shotdown");
		}
	}	
}
