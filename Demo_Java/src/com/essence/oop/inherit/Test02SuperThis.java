package com.essence.oop.inherit;

class Animal02 {
	void eat() {
		System.out.println("animal : eat");
	}
}

class Dog extends Animal02 {
	void eat() {
		System.out.println("dog : eat");
	}

	void eatTest() {
		this.eat(); // this 调用自己的方法
		super.eat(); // super 调用父类方法
	}
}

public class Test02SuperThis {
	public static void main(String[] args) {
		Animal02 a = new Animal02();
		a.eat();
		Dog d = new Dog();
		d.eatTest();
	}
}
