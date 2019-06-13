/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: UnsafeLazyInitialization.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.doubleCheck;

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
