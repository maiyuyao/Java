﻿package com.essence.base.d07_interface.ex01;

public class CellPhone extends Telphone {
	@Override
	public void call() {
		System.out.println("通过键盘来打电话");
	}
	@Override
	public void message() {
		System.out.println("通过键盘来发短信");
	}
}
