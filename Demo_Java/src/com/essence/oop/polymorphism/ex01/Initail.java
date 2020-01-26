package com.essence.oop.polymorphism.ex01;

public class Initail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Animal obj1 = new Animal();//父类的引用是可以指本类
		Animal obj2 = new Dog();//父类的引用是可以指向子类对象的
		Animal obj3 = new Cat();
		//Dog obj3 = new Animal();//错 
		obj1.eat();
		obj2.eat();
		obj3.eat();
		 */
		Dog dog = new Dog();
		Animal animal = dog;//向上类型转换，自动类型提升
		if(animal instanceof Dog){
			Dog dog2 = (Dog)animal; //强制类型转换存在风险
		}else{
			System.out.println("无法进行类型转换 转换成Dog类型");
		}
		if(animal instanceof Cat){
			Cat cat = (Cat)animal;//1.编译时 Cat类型，不会出错； 2.运行时 Dog类型 ，报错。
		}else{
			System.out.println("无法进行类型转换 转换成Cat类型");
		}
	}
}
