/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: SleepUtils.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

	public static final void second(long seconds){
		try{
			TimeUnit.SECONDS.sleep(seconds);
		}catch(Exception e){
			
		}
	}
}
