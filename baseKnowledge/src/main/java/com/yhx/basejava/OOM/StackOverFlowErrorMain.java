package com.yhx.basejava.OOM;

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
