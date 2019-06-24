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

package bigmoon.learning.basejava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		ArrayList<String> array=new ArrayList<String>();
		
		array.add("abc");
		array.add("1234");
		array.add("中文");
		
		for(String str:array){
			System.out.println(str);
		}
		
		Iterator<String> it=array.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		List<? extends Fruit> fruits=new ArrayList<Apple>();
		Apple apple=new Apple();
		//fruits.add(apple);
		
		Class str=new ArrayList<String>().getClass();
		Class intList=new ArrayList<Integer>().getClass();
		
		System.out.println(str==intList);
	}

}
