package com.yhx.basejava.generaic;

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
