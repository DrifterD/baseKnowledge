package com.yhx.basejava.polyMorphic;

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
