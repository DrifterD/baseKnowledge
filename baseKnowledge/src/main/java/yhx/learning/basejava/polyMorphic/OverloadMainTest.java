/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: OverloadMainTest.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.polyMorphic;

public class OverloadMainTest {

	static class A {

		public String show(D obj) {
			return ("A and D");
		}

		public String show(A obj) {
			return ("A and A");
		}
	}

	static class B extends A {
		
		public String show(A obj) {
			return ("B and A");
		}

		
		public String show(B obj) {
			return ("B and B");
		}
		
		
	}

	static class C extends B {
	}

	static class D extends B {
	}

	public static void main(String[] args) {
		A ab = new B();
		B b = new B();
		C c = new C();
		System.out.println(ab.show(b));
		System.out.println(ab.show(c));
//		System.out.println("-------------");
//		System.out.println(bb.show(b));
//		System.out.println(bb.show(c));
	}
}
