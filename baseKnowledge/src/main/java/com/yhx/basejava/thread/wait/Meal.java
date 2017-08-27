package com.yhx.basejava.thread.wait;

public class Meal {

	private int orderNumber;
	
	
	
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Meal(int orderNumber){
		this.orderNumber=orderNumber;
	}
	
	public String toString(){
		return "meal ="+this.orderNumber;
	}
}
