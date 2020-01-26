package com.essence.base.d08_InnerOuter;

interface Print {
	void print1();
}

public class AnonymousInnerClass {

	// 1、this method use 'Anonymous Inner Class' .
	public Print dest() {
		return new Print() {
			public void print1() {
				System.out.println("Hello world!!");
			}
		};
	}

	// the 'main' method.
	public static void main(String args[]) {
		AnonymousInnerClass a = new AnonymousInnerClass();
		Print p = a.dest();
		p.print1();
	}

}