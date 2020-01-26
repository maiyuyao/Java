package com.essence.oop.polymorphism.ex03;

abstract class Animal02 {
	abstract void eat();
}

class Cat02 extends Animal02 {
	public void eat() {
		System.out.println("吃鱼");
	}

	public void work() {
		System.out.println("抓老鼠");
	}
}

class Dog02 extends Animal02 {
	public void eat() {
		System.out.println("吃骨头");
	}

	public void work() {
		System.out.println("看家");
	}
}

public class TestPolymorphism {

	public static void main(String[] args) {
		show(new Cat02()); // 以 Cat 对象调用 show 方法
		show(new Dog02()); // 以 Dog 对象调用 show 方法

		Animal02 a = new Cat02(); // 向上转型
		a.eat(); // 调用的是 Cat 的 eat
		Cat02 c = (Cat02) a; // 向下转型
		c.work(); // 调用的是 Cat 的 work
	}

	public static void show(Animal02 a) {
		a.eat();
		// 类型判断
		if (a instanceof Cat02) { // 猫做的事情
			Cat02 c = (Cat02) a;
			c.work();
		} else if (a instanceof Dog02) { // 狗做的事情
			Dog02 c = (Dog02) a;
			c.work();
		}
	}
}
