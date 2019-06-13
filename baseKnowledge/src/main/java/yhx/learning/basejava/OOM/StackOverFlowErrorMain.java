/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: StackOverFlowErrorMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.OOM;

//-Xss128k
public class StackOverFlowErrorMain {

	public static void main(String[] args) {
		StackOverFlowErrorMain sfe = new StackOverFlowErrorMain();
		JVMSOFClass jc = sfe.new JVMSOFClass();

		try {
			jc.stackLeak();

		} catch (Exception ex) {
			System.out.println("stack length:" + jc.index);
		} finally {

		}
	}

	class JVMSOFClass {

		private int index = 0;

		public void stackLeak() {
			this.index++;
			stackLeak();
		}

	}

}
