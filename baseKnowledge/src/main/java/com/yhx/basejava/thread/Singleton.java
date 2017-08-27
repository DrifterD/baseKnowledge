package com.yhx.basejava.thread;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
	 public    static Singleton singleton =null;
	    public static Map m;
	    static{
	        m = new HashMap();
	        System.out.println("init Singleton 1");		
	    }
	    private Singleton(){
	        initM();
	        System.out.println("init Singleton 2");		
	    }
	    public static void initM(){
	        if(null == m){
	            System.out.println("m 为空");
	            m = new HashMap();
	        }
	        m.put("1", "郑");
	        m.put("2", "陈");
	    }
	    public static Singleton getInstance(){
	        return singleton;
	    }
}