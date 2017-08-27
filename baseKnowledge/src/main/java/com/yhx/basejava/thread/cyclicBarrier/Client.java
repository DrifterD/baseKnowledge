package com.yhx.basejava.thread.cyclicBarrier;

public class Client {

	public static void main(String[] args) {
		BankWaterServer bws=new BankWaterServer();
		bws.testCyclicBarrier();

	}

}
