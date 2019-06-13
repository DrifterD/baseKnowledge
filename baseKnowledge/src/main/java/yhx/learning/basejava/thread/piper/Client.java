/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: Client.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.piper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Sender sender=new Sender();
		Reciver reciver=new Reciver(sender);
		
		ExecutorService excoter=Executors.newCachedThreadPool();
		excoter.execute(sender);
		excoter.execute(reciver);
		TimeUnit.SECONDS.sleep(10);
		excoter.shutdown();
	}

}
