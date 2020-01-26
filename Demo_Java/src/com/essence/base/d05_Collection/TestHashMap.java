package com.essence.base.d05_Collection;

import java.util.*;

/*Map<K, V>是一种键-值映射表，当我们调用put(K key, V value)方法时，就把key和value做了映射并放入Map。
 * 当我们调用V get(K key)时，就可以通过key获取到对应的value。
    如果key不存在，则返回null。和List类似，Map也是一个接口，最常用的实现类是HashMap。*/
public class TestHashMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 123);
		map.put("pear", 456);
		System.out.println(map.get("apple")); // 123
		map.put("apple", 789); // 再次放入apple作为key，但value变为789
		System.out.println(map.get("apple")); // 789
	}
}