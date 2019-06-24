/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: SleepUtils.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

	public static final void second(long seconds){
		try{
			TimeUnit.SECONDS.sleep(seconds);
		}catch(Exception e){
			
		}
	}
}
