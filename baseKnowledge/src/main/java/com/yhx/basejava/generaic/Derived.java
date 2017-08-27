package com.yhx.basejava.generaic;

public class Derived<T> extends GenericBase<T> {

	public Derived(Class<T> kind){
		super(kind);
	}
}
