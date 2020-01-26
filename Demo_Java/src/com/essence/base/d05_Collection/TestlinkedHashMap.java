package com.essence.base.d05_Collection;

import java.util.*;
import java.util.Map.Entry;

/*
 * LinkedHashMap是HashMap的一个子类，它保留插入的顺序。
 * 如果需要输出的顺序和输入时的相同，那么就选用LinkedHashMap。*/
public class TestlinkedHashMap {
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("name1", "josan1");
		hashMap.put("name2", "josan2");
		hashMap.put("name3", "josan3");
		Set<Entry<String, String>> set = hashMap.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry entry = iterator.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println("key:" + key + ",  value:" + value);
		}

		System.out.println("");
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("name1", "josan1");
		linkedHashMap.put("name2", "josan2");
		linkedHashMap.put("name3", "josan3");
		Set<Entry<String, String>> set02 = linkedHashMap.entrySet();
		Iterator<Entry<String, String>> iterator02 = set02.iterator();
		while (iterator02.hasNext()) {
			Entry entry02 = iterator02.next();
			String key02 = (String) entry02.getKey();
			String value02 = (String) entry02.getValue();
			System.out.println("key:" + key02 + ",  value:" + value02);
		}
	}
}