package com.essence.advanced.reflect.ex03;

import com.essence.advanced.reflect.ex04.ClassUtil;

public class ClassDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassUtil.printFieldMessage("hello");
		System.out.println("=============");
		ClassUtil.printFieldMessage(new Integer(1));

	}

}
