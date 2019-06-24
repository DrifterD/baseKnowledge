/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: SwitchMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.ExectorFlow;

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
