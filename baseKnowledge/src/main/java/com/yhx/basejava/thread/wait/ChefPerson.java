package com.yhx.basejava.thread.wait;

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
