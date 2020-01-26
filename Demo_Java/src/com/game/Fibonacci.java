package com.game;

/*1.斐波那契数列指的是这样一个数列 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,377,610...
2.特别指出：第0项是0,第1项是第一个1。
3.这个数列从第三项开始,每一项都等于前两项之和。*/
public class Fibonacci {

	public static long fibonacci(long number) {
		if ((number == 0) || (number == 1))
			return number;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

	public static void main(String[] args) {
		for (int counter = 0; counter <= 19; counter++) {
			System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
		}
	}
}
