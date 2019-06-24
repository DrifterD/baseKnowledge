/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Client.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread;

public class Client {

	public synchronized void f1(int count){
		if(count-->0){
			System.out.println("f1 callign f2() with count ="+count);
			f2(count);
		}
	}
	
	
	public synchronized void f2(int count){
		if(count-->0){
			System.out.println("f2 callign f1() with count ="+count);
			f1(count);
		}
	}
	
	public static void main(String[] args) {
		
		//InstanceFacotry.getInstance();
		InstanceFacotry.getMyInstance();
		Singleton.getInstance();
		System.out.println("end");
		
/*		final Client c=new Client();
		
		new Thread(){

			@Override
			public void run() {
				c.f1(10);
			}
			
		}.start();*/
		
		Instance.testMethod();
		System.out.println("");
	}

}
