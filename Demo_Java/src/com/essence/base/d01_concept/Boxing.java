package com.essence.base.d01_concept;

public class Boxing {

	public static void main(String[] args) {
		String str1 = "Java"; // 方式1
		String str2 = "Java";
		String str3 = new String("Java"); // 方式2
		String str4 = new String("Java");

		System.out.println(str1 == str2);// false
		System.out.println(str3 == str4);// true
	}
}
