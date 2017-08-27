package com.yhx.basejava.thread.wait;

public class Car {

	private boolean waxOn=false;
	
	public boolean isWaxOn() {
		return waxOn;
	}



	public void setWaxOn(boolean waxOn) {
		this.waxOn = waxOn;
	}

	public Car(){
		
	}
	
	public synchronized void waxed(){
		this.waxOn=true;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException{
		
		while(!this.waxOn){
			wait();
		}		
	}
	
	public synchronized void buff(){
		this.waxOn=false;
		notifyAll();
	}
	
	public synchronized void waitForBuffing() throws InterruptedException{
		while(this.waxOn){
			wait();
		}
	}
	
}
