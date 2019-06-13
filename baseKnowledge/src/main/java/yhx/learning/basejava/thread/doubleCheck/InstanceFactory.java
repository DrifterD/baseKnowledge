/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: InstanceFactory.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.doubleCheck;

public class InstanceFactory {

	private static class InstaceHolder{
		public static Instance instance=new Instance();
	}
	
	public  Instance getInstance(){		
		return InstaceHolder.instance;		
	}
	
	public static void main(String[] args){
		
		Thread t1=new Thread(new Runnable(){

			public void run() {
				InstanceFactory factory=new InstanceFactory();
				factory.getInstance();
				System.out.println("t1 has done");
			}
		});
		t1.setName("t1");
		
		Thread t2=new Thread(new Runnable(){

			public void run() {
				InstanceFactory factory=new InstanceFactory();
				factory.getInstance();
				System.out.println("t2 has done");				
			}
		});
		t2.setName("t2");
		
		Thread t3=new Thread(new Runnable(){

			public void run() {
				InstanceFactory factory=new InstanceFactory();
				factory.getInstance();
				System.out.println("t3 has done");				
			}
		});
		t3.setName("t2");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
