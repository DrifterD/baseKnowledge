package com.yhx.basejava.thread.doubleCheck;

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
