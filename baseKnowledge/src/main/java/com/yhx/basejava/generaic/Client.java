package com.yhx.basejava.generaic;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		GenericBase<Building> gb=new GenericBase<Building>(Building.class);
		System.out.println(gb.f(new Building()));
		System.out.println(gb.f(new House()));
		
		GenericBase<House> gb2=new GenericBase<House>(House.class);
		System.out.println(gb2.f(new Building()));
		System.out.println(gb2.f(new House()));
		
		
		List<? super House> first =new ArrayList<Building>();
		first.add(new House());
		
	}

	public static void firstGeneratic(){
		List<?> list=new ArrayList<Integer>();
	}

}
