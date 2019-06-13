/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: ConnectionDriver.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.waitTimeOut;

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
