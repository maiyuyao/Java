package com.essence.base.d05_Collection;

import java.util.*;

/*
 * LinkedHashSet继承自HashSet，其底层是基于LinkedHashMap来实现的，有序，非同步。
   LinkedHashSet集合同样是根据元素的hashCode值来决定元素的存储位置，但是它同时使用链表维护元素的次序。
    这样使得元素看起来像是以插入顺序保存的，
    也就是说，当遍历该集合时候，LinkedHashSet将会以元素的添加顺序访问集合的元素。*/

public class TestlinkedHashSet {
	public static void main(String[] args) {
		// 测试1
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		HashSet<String> hashSet = new HashSet<>();

		linkedHashSet.add("I" + 1);
		linkedHashSet.add("I" + 6);
		linkedHashSet.add("I" + 2);
		linkedHashSet.add("I" + 5);
		linkedHashSet.add("CC");
		linkedHashSet.add("I" + 4);
		hashSet.add("I" + 1);
		hashSet.add("I" + 6);
		hashSet.add("I" + 2);
		hashSet.add("I" + 5);
		hashSet.add("CC");
		hashSet.add("I" + 4);

		System.out.println("linkedHashSet遍历：");
		for (String string : linkedHashSet) {
			System.out.print(string + " ");
		}
		System.out.println();

		System.out.println("hashSet遍历：");
		for (String string : hashSet) {
			System.out.print(string + " ");
		}

		// 测试2
		LinkedHashSet<String> linkedHashSet02 = new LinkedHashSet<>();
		HashSet<String> hashSet02 = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			linkedHashSet02.add("I" + i);
			hashSet02.add("I" + i);
		}

		System.out.println("\r\rlinkedHashSet01遍历：");
		for (String string : linkedHashSet02) {
			System.out.print(string + " ");
		}
		System.out.println();

		System.out.println("hashSet遍历02：");
		for (String string : hashSet02) {
			System.out.print(string + " ");
		}
	}
}