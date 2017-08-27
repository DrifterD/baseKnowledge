package com.yhx.basejava.thread.waitTimeOut;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class ConnectionDriver {
	
	static class ConnectionHandler implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
			if(method.getName().equals("commit")){
				//System.out.println("connection commit");
				TimeUnit.MILLISECONDS.sleep(100);
			}
			
			
			return null;		
		}
	}
	
	public static final Connection createConncetion(){
		return (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
				new Class<?>[]{(Connection.class)}, new ConnectionHandler());
	}

}
