package com.essence.advanced.annotation.ex01;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class ShowField {
	public static void main(String[] args) {
		ShowField hello =new ShowField();
		Person person=new Person();
		person.name="张三";
		person.city="中山******************";
		
		try {
			hello.check(person);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
	
	void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
		// 遍历所有Field:
		for (Field field : person.getClass().getFields()) {
			// 获取Field定义的@Range:
			Range range = field.getAnnotation(Range.class);
			// 如果@Range存在:
			if (range != null) {
				// 获取Field的值:
				Object value = field.get(person);
				// 如果值是String:
				if (value instanceof String) {
					String s = (String) value;
					// 判断值是否满足@Range的min/max:
					if (s.length() < range.min() || s.length() > range.max()) {
						throw new IllegalArgumentException("Invalid field: " + field.getName());
					}
					else {
						System.out.println("字段： " + field.getName()+"-"+value);
					}
				}
			}
		}
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
	int min() default 0;
	int max() default 10;
}

class Person {
	@Range(min = 1, max = 10)
	public String name;
	@Range(max = 10)
	public String city;
}