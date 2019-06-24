/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Reciver.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.piper;

import java.io.IOException;
import java.io.PipedReader;

public class Reciver implements Runnable{

	private Sender sender;
	private PipedReader reader;
	public Reciver(Sender sender){
		
		try {
			this.reader=new PipedReader(sender.getOut());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		
		while(true){
			try {
				System.out.println("reader:"+(char)reader.read());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
