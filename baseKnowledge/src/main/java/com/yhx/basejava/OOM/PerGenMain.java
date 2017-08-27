package com.yhx.basejava.OOM;

import java.util.ArrayList;
import java.util.List;

public class PerGenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();	
		int i=0;
		
		while(true){			
			list.add(String.valueOf(i++));
		}
	}

}
