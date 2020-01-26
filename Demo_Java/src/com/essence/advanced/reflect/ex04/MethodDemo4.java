package com.essence.advanced.reflect.ex04;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hello");
		//list1.add(20);错误的
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1 == c2);
		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list1, 20);//绕过编译操作就绕过了泛型
			System.out.println(list1.size());
			System.out.println(list1);
			/*for (String string : list1) {
				System.out.println(string);
			}*///现在不能这样遍历
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
}
