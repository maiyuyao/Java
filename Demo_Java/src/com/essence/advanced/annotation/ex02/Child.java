package com.essence.advanced.annotation.ex02;

@Description(desc="i am annotation on class", author = "Child")
public class Child implements people {
	@Override
	@Description(desc="i am annotation1 on methods", author = "name")
	public String name() {
		return null;
	}

	@Override
	@Description(desc="i am annotation2 on methods", author = "age")
	public int age() {
		return 0;
	}

	@Override
	public void work() {
	}
}
