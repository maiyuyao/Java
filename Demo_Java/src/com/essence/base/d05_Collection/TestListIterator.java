package com.essence.base.d05_Collection;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestListIterator {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("aaa");
		a.add("bbb");
		a.add("ccc");
		System.out.println("iterate前 : " + a);
		// listIterator操作
		ListIterator<String> it = a.listIterator();
		System.out.println("打印前后元素Index");
		while (it.hasNext()) {
			System.out.println(it.next() + ", " + it.previousIndex() + ", " + it.nextIndex());
		}
		// 从后往前打印
		System.out.print("从后往前打印: ");
		while (it.hasPrevious()) {
			System.out.print(it.previous() + " ");
		}
		System.out.println();
		// 调用listIterator(n)方法创建一个一开始就指向列表索引为n的元素处的ListIterator。
		it = a.listIterator(1);
		while (it.hasNext()) {
			String t = it.next();
			System.out.println("it.next(): " + t);
			// 判断下一个元素是不是"ccc"，并对本元素赋值
			if ("ccc".equals(t)) {
				it.set("nnn");
			} else {
				it.add("kkk");
			}
		}
		System.out.println("iterate后 : " + a);
	}
}