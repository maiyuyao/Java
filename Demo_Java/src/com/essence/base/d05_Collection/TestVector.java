package com.essence.base.d05_Collection;

import java.util.Vector;
import java.util.Enumeration;

/*
 * 创建了一个向量类的对象后，可以往其中随意插入不同类的对象.
 * 即不需顾及类型也不需预先选定向量的容量，并可以方便地进行查找。
    对于预先不知或者不愿预先定义数组大小，并且需要频繁地进行查找，插入，删除工作的情况，可以考虑使用向量类。*/
public class TestVector {
	public static void main(String args[]) {
		Vector v1 = new Vector();
		Integer integer1 = new Integer(1);
		// 加入为字符串对象
		v1.addElement("one");
		// 加入的为integer的对象
		v1.addElement(integer1);
		v1.addElement(integer1);
		v1.addElement("two");
		v1.addElement(new Integer(2));
		v1.addElement(integer1);
		v1.addElement(integer1);
		// 转为字符串并打印
		System.out.println("Vecto新增1: " + v1);
		// 向指定位置插入新对象
		v1.insertElementAt("three", 2);
		v1.insertElementAt(new Float(3.9), 3);
		System.out.println("Vector新增2: " + v1);
		// 将指定位置的对象设置为新的对象，指定位置后的对象依次往后顺延
		v1.setElementAt("four", 2);
		System.out.println("Vector新增3: " + v1);
		// 从向量对象v1中删除对象integer1
		// 由于存在多个integer1,所以从头开始，找删除找到的第一个integer1.
		v1.removeElement(integer1);
		System.out.println("Vector删除后: " + v1);
		// Vector转Enumeration
		Enumeration enumeration = v1.elements();
		System.out.print("Enumeration: ");
		while (enumeration.hasMoreElements())
			System.out.print(enumeration.nextElement() + " ");
		System.out.println();
		// 按不同的方向查找对象integer1所处的位置
		System.out.println("1在Vector的第一个位置: " + v1.indexOf(integer1));
		System.out.println("1在Vector的最后一个位置: " + v1.lastIndexOf(integer1));
		// 重新设置v1的大小，多余的元素被抛弃
		v1.setSize(4);
		System.out.println("Vector最新: " + v1);
	}
}