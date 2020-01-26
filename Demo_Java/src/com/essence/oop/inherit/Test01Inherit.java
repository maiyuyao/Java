package com.essence.oop.inherit;

class Animal01 {
	private String name;
	private int id;

	public Animal01(String myName, int myid) {
		name = myName;
		id = myid;
	}

	public void eat() {
		System.out.println(name + "正在吃");
	}

	public void sleep() {
		System.out.println(name + "正在睡");
	}

	public void introduction() {
		System.out.println("大家好！我是" + id + "号" + name + ".");
	}
}

class Penguin1 extends Animal01 { //企鹅类继承父类之后，就具有父类当中的属性和方法
	public Penguin1(String myName, int myid) {
		super(myName, myid);
	}
}

class Mouse1 extends Animal01 {
	public Mouse1(String myName, int myid) {
		super(myName, myid); //企鹅类类继承父类之后，就具有父类当中的属性和方法
	}
}

public class Test01Inherit {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Penguin1 a = new Penguin1("企鹅", 1);
		Mouse1 b = new Mouse1("豚鼠", 2);
		a.eat();
		a.sleep();
		a.introduction();
		
		b.eat();
		b.sleep();
		b.introduction();

	}

}
