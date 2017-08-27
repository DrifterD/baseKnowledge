package com.yhx.basejava.thread.threadlocal;

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
