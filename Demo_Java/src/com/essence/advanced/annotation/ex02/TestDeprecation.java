package com.essence.advanced.annotation.ex02;

public class TestDeprecation {
	@SuppressWarnings("deprecation")
	public void work() {
		people people = new Child();
		people.work();
	}
}