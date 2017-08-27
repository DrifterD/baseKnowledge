package com.yhx.basejava.collections;

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
