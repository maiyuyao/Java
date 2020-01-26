package com.essence.base.d05_Collection;

import java.util.*;

/*
 * TreeMap 是一个有序的key-value集合，非同步，基于红黑树(Red-Black tree)实现。
 * 每一个key-value节点作为红黑树的一个节点。TreeMap存储时会进行排序的，会根据key来对key-value键值对进行排序。
 * 其中排序方式也是分为两种，一种是自然排序，一种是定制排序，具体取决于使用的构造方法。*/

public class TestTreeMap {
	public static void main(String[] args) {
		// 创建HashMap,LinkedHashMap,TreeMap实例
		HashMap<String, String> hashMap = new HashMap();
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
		TreeMap<String, String> treeMap = new TreeMap();
		// 分别写入数据与字母的键值对，如：1-A,2-B...
		for (int i = 0; i < 26; i++) {
			hashMap.put(String.valueOf(i), String.valueOf((char) (65 + i)));
			linkedHashMap.put(String.valueOf(i), String.valueOf((char) (65 + i)));
			treeMap.put(String.valueOf(i), String.valueOf((char) (65 + i)));
		}

		// 打印hashMap
		Iterator<String> iteratorHashMap = hashMap.keySet().iterator();
		System.out.println("HashMap-->");
		while (iteratorHashMap.hasNext()) {
			Object key1 = iteratorHashMap.next();
			System.out.println("[" + key1 + "-" + hashMap.get(key1) + "]");
		}

		// 打印LinkedHashMap
		Iterator<String> iteratorLinkedHashMap = linkedHashMap.keySet().iterator();
		System.out.println("\n\nLinkedHashMap-->");
		while (iteratorLinkedHashMap.hasNext()) {
			Object key2 = iteratorLinkedHashMap.next();
			System.out.println("[" + key2 + "-" + linkedHashMap.get(key2) + "]");
		}

		// 打印TreeMap
		Iterator<String> iteratorTreeMap = treeMap.keySet().iterator();
		System.out.println("\n\nTreeMap-->");
		while (iteratorTreeMap.hasNext()) {
			Object key3 = iteratorTreeMap.next();
			System.out.println("[" + key3 + "-" + treeMap.get(key3) + "]");
		}
	}
}