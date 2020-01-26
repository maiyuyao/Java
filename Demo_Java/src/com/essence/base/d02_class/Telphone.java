package com.essence.base.d02_class;

//定义一个类
public class Telphone {
	// 属性(成员变量) => 有什么
	float screen;
	float cpu;
	float mem;
	int var = 30; // 成员变量，定义在类中
	// 方法 => 干什么

	void call() {
		// 局部变量与成员变量重名，局部变量具有更高的优先级(就近原则)
		int var = 40;
		System.out.println("var:" + var);

		int localVar = 10;// 局部变量，定义在方法中
		System.out.println("localVar:" + localVar);
		System.out.println("var:" + var);

		System.out.println("Telphone有打电话的功能!");
	}

	// 一般方法
	void sendMessage() {
		int localVar = 20;// 局部变量，定义在方法中
		System.out.println("localVar:" + localVar);
		System.out.println("var:" + var);
		System.out
				.println("screen:" + screen + " cpu:" + cpu + " mem:" + mem + " Telphone有发短信的功能!");
	}

	// 构造方法与类名相同，没有返回值
	public Telphone() {
		System.out.println("无参构造方法执行了!");
	}

	// 带参的构造方法
	public Telphone(float newScreen, float newCpu, float newMem) {
		screen = newScreen;
		cpu = newCpu;
		mem = newMem;
		System.out.println("有参构造方法执行了!");
	}
}
