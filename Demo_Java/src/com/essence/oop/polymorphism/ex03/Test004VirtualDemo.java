package com.essence.oop.polymorphism.ex03;

public class Test004VirtualDemo {

	public static void main(String[] args) {
		Test004Salary s = new Test004Salary("员工 A", "北京", 3, 3600.00);
		Test004Employee e = new Test004Salary("员工 B", "上海", 2, 2400.00);
		System.out.println("使用 Salary 的引用调用 mailCheck -- ");
		s.mailCheck();
		System.out.println("\n使用 Employee 的引用调用 mailCheck--");
		e.mailCheck();
	}
}