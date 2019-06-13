/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: Meal.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.wait;

public class Meal {

	private int orderNumber;
	
	
	
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Meal(int orderNumber){
		this.orderNumber=orderNumber;
	}
	
	public String toString(){
		return "meal ="+this.orderNumber;
	}
}
