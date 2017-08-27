package com.yhx.basejava.ExectorFlow;

public class SwitchMain {

	public static void main(String[] args) {
		
		
		switch(3){
		case 1:System.out.println("case 1");
		case 2:{System.out.println("case 2");return;}
		case 3:System.out.println("case 3");System.out.println("3.44");System.out.println("3.54");
		System.out.println("3.64");break;
		case 4:System.out.println("case 4");
		default:System.out.println("333");
		}
		

	}

}
