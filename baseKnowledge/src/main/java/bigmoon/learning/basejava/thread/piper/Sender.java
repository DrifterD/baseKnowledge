/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Sender.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-6-13 上午11:19      版本号        描述
 */

package bigmoon.learning.basejava.thread.piper;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sender implements Runnable {

	private PipedWriter out=new PipedWriter();	
	private Random random=new Random();
	
	public PipedWriter getOut() {
		return out;
	}
	
	public void run() {

		try{
		while(true){
			
			for(char a='a';a<='z';a++){
				try {
					out.write(a);
					System.out.println("writer:"+a);
					TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}catch(InterruptedException ex){
			System.out.println("close thread");
		}
		
	}

}
