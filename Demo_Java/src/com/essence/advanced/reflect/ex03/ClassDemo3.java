package com.essence.advanced.reflect.ex03;

import com.essence.advanced.reflect.ex04.ClassUtil;

public class ClassDemo3 {
	public static void main(String[] args) {
		String s = "hello";
		ClassUtil.printClassMethodMessage(s);
		
	    Integer n1 = 1;
	    ClassUtil.printClassMethodMessage(n1);
	}

}
