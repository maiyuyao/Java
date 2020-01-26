package com.essence.advanced.reflect.ex04;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) {
		// 获取类的信息首先要获取类的类类型
		A a1 = new A();
		Class c = a1.getClass();
		try {
			// 获取print(int ,int)方法
			System.out.println("print(int ,int)方法：");
			// 获取方法(名称和参数列表来决定调用的哪个方法),getMethod获取的是public的方法
			// Method m = c.getMethod("print", new Class[]{int.class,int.class});
			Method m = c.getMethod("print", int.class, int.class);

			// 方法的反射操作
			// 方法如果没有返回值返回null,有返回值返回具体的返回值
			// Object o = m.invoke(a1,new Object[]{10,20});
			Object o = m.invoke(a1, 10, 20);

			// 获取方法print(String,String)
			System.out.println("print(String,String)方法：");
			Method m1 = c.getMethod("print", String.class, String.class);
			// 用方法进行反射操作
			o = m1.invoke(a1, "hello", "WORLD");
			// 获取方法print()
			System.out.println("print()方法：");
			// Method m2 = c.getMethod("print", new Class[]{});
			Method m2 = c.getMethod("print");
			// m2.invoke(a1, new Object[]{});
			m2.invoke(a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class A {
	public void print() {
		System.out.println("helloworld");
	}

	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}