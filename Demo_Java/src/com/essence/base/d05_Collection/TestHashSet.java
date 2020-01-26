package com.essence.base.d05_Collection;

import java.util.*;

/*HashSet 是一个没有重复元素的集合。它是由HashMap实现的，不保证元素的顺序
 * (这里所说的没有顺序是指： 元素插入的顺序与输出的顺序不一致)。
  HashSet的实现方式大致如下，通过一个HashMap存储元素.
  元素是存放在HashMap的Key中，而Value统一使用一个Object对象。*/
public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		System.out.println(set.add("abc")); // true
		System.out.println(set.add("xyz")); // true
		System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
		System.out.println(set.contains("xyz")); // true，元素存在
		System.out.println(set.contains("XYZ")); // false，元素不存在
		System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
		System.out.println(set.size()); // 2，一共两个元素
		System.out.println("打印全部元素: ");
		for (String s : set) {
			System.out.println(s);
		}
	}
}