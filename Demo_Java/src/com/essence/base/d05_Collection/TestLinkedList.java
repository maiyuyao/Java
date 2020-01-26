package com.essence.base.d05_Collection;

import java.util.LinkedList;

/*
 * ArrayList是一个动态数组，而LinkedList是一个双向链表。
 * 所以它除了有ArrayList的基本操作方法外还额外提供了get，remove，insert方法在LinkedList的首部或尾部。*/
public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();

		linkedList.add("first");
		linkedList.add("second");
		linkedList.add("third");
		System.out.println(linkedList);

		linkedList.addFirst("addFirst");
		System.out.println(linkedList);

		linkedList.addLast("addLast");
		System.out.println(linkedList);

		linkedList.add(2, "addByIndex");
		System.out.println(linkedList);
	}
}