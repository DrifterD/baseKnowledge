
/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Resetorantor.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Resetorantor {

	 Meal meal;
	private ExecutorService executors;
	
	public Resetorantor(int count){
		this.executors=Executors.newCachedThreadPool();
		meal=new Meal(count);
	}
	
	public void shutdown(){
		this.executors.shutdownNow();
	}
	
	public static void main(String[] args){
		
		Resetorantor rest=new Resetorantor(0);
		rest.executors.execute(new WaiterPerson(rest));
		rest.executors.execute(new WaiterPerson(rest));
		rest.executors.execute(new ChefPerson(rest));
		rest.executors.execute(new ChefPerson(rest));	
	}
}
