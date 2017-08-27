package com.yhx.basejava.thread.doubleCheck;

public class UnsafeLazyInitialization {

	private static Instance instance;
	
	public synchronized static Instance getInstance(){
		
		if(instance==null){
			instance=new Instance();			
		}
		return instance;
	}
	
	public static void main(String[] args){
		

		Thread t1=new Thread(new Runnable(){

			public void run() {
				Instance tmpInstance=UnsafeLazyInitialization.getInstance();
				System.out.println("t1 has done, name="+tmpInstance.getName());
			}
		});
		t1.setName("t1");
		
		Thread t2=new Thread(new Runnable(){

			public void run() {
				Instance tmpInstance=UnsafeLazyInitialization.getInstance();
				
				System.out.println("t2 has done, name="+tmpInstance.getName());				
			}
		});
		t2.setName("t2");
		
		t1.start();
		t2.start();	
		
	}
	
	
}
