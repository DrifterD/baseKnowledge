/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: ChefPerson.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.wait;

public class ChefPerson implements Runnable{

	private int count;
	private Resetorantor rest;
	
	public ChefPerson(Resetorantor rest){
		this.rest=rest;
	}
	
	
	public void run() {
		
		try {
		while(!Thread.interrupted()){
			
			synchronized(this.rest){
				
				while(this.rest.meal.getOrderNumber()!=0){
					
						this.rest.wait();				
				}
				
				this.count++;
				this.rest.meal=new Meal(this.count);
				System.out.println(Thread.currentThread().getName()+" , "+this.rest.meal);
				Thread.sleep(1000);							
				//this.rest.notify();
				this.rest.notifyAll();
			}
		}
		
		} catch (InterruptedException e) {
			System.out.println("chef shutdown");
		}
	}

	
}
