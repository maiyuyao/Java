package com.essence.base.d08_InnerOuter;

public class StaticMethods {

	// static 修饰的成员称为静态成员或类成员，被类的所有对象所共享。
	static String NAME = "randy";

	public static void main(String[] args) {
		// 静态成员可以使用类名直接访问(推荐)，也可以使用对象名进行访问。
		System.out.println("通过类名访问: " + StaticMethods.NAME);
		// 创建类对象
		StaticMethods hello = new StaticMethods();
		// 使用对象名访问静态变量
		System.out.println("通过对象名访问: " + StaticMethods.NAME);
		// 使用对象名的形式修改静态变量
		hello.NAME = "Dick";
		// 值已经被修改
		System.out.println("通过类名访问: " + StaticMethods.NAME);
	}

}
