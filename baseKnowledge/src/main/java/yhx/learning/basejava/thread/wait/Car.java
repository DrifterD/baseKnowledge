/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: Car.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.wait;

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
