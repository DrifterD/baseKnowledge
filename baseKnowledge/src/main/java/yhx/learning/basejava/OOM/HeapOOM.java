/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: HeapOOM.java
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

/*
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printgcdetail 
 *  -xx:surivorratio=8
 */
public class HeapOOM {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<OOMObject>();
		
		while(true){
			list.add(new OOMObject());
		}

	}

}
