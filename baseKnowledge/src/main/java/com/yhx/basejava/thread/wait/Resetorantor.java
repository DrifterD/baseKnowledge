
package com.yhx.basejava.thread.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Resetorantor {

	 Meal meal;
	private ExecutorService executors;
	
	public Resetorantor(int count){
		this.executors=Executors.newCachedThreadPool();
		meal=new Meal(count);
	}
	
	public void shutdown(){
		this.executors.shutdownNow();
	}
	
	public static void main(String[] args){
		
		Resetorantor rest=new Resetorantor(0);
		rest.executors.execute(new WaiterPerson(rest));
		rest.executors.execute(new WaiterPerson(rest));
		rest.executors.execute(new ChefPerson(rest));
		rest.executors.execute(new ChefPerson(rest));	
	}
}
