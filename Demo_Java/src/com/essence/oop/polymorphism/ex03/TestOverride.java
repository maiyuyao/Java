package com.essence.oop.polymorphism.ex03;

class Animal {
	public void move() {
		System.out.println("动物可以移动");
	}
}

class Dog extends Animal {
	public void move() {
		System.out.println("狗可以跑和走");
	}

	public void bark() {
		System.out.println("狗可以吠叫");
	}
}

public class TestOverride {
	public static void main(String args[]) {
		Animal a = new Animal(); // Animal 对象
		Animal b = new Dog(); // Dog 对象

		a.move();// 执行 Animal 类的方法

		b.move();// 执行 Dog 类的方法
		((Dog) b).bark(); // 子类继承父类，子类里面定义一个父类里面没有的方法，调用的时候提示失败，
		                  // 有两个方法解决：1.是父类新增这个函数，2.是对子类进行强转
	}
}