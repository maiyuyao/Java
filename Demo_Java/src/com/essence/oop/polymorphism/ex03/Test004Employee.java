package com.essence.oop.polymorphism.ex03;

public class Test004Employee {

	private String name;
	private String address;
	private int number;

	//构造函数，设置值
	public Test004Employee(String name, String address, int number) {
		System.out.println("Employee 构造函数");
		this.name = name;
		this.address = address;
		this.number = number;
	}

	//打印信息
	public void mailCheck() {
		System.out.println("邮寄支票给： " + this.name + " " + this.address);
	}
	//打印信息
	public String toString() {
		return name + " " + address + " " + number;
	}

	//给外部提取名字
	public String getName() {
		return name;
	}
 
	//给外部提取地址
	public String getAddress() {
		return address;
	}

	//设置地址
	public void setAddress(String newAddress) {
		address = newAddress;
	}

	//给外部提取号码
	public int getNumber() {
		return number;
	}
}