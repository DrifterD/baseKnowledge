package com.yhx.basejava.thread.piper;

import java.io.IOException;
import java.io.PipedReader;

public class Reciver implements Runnable{

	private Sender sender;
	private PipedReader reader;
	public Reciver(Sender sender){
		
		try {
			this.reader=new PipedReader(sender.getOut());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		
		while(true){
			try {
				System.out.println("reader:"+(char)reader.read());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
