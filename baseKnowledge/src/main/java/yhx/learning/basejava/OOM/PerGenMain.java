/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: PerGenMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.OOM;

import java.util.ArrayList;
import java.util.List;

public class PerGenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();	
		int i=0;
		
		while(true){			
			list.add(String.valueOf(i++));
		}
	}

}