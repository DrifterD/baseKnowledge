/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: GenericBase.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.generaic;

public class GenericBase<T> {

	private Class<T> kind;
	private T element;
	public void set(T arg){
		arg=element;
	}
	
	public T get(){
		return element;
	}
	
	public GenericBase(Class<T> kind){
		this.kind=kind;
	}
	
	public boolean f(Object args){
		return kind.isInstance(args);
	}
}
