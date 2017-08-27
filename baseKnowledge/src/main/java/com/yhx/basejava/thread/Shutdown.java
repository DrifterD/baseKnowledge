package com.yhx.basejava.thread;

public class Shutdown {

	public static void main(String[] args) throws InterruptedException{
		Runner tmp=new Runner();
		Thread t=new Thread(tmp);
		t.setDaemon(true);
		t.start();
		Thread.sleep(30);
		
		t.interrupt();
		System.out.println("cancle");
		Thread.sleep(3000);
		
	}
	
	private static class Runner implements Runnable{
		
		private boolean on=true;
		Integer i=0;
		public void run(){			
			while(on && !Thread.currentThread().isInterrupted()){
				i++;
				System.out.println("i="+i);
			}
		}
		
		public void cancle(){
			on=false;
		}
			
	}
}
