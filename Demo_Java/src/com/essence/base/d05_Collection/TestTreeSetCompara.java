package com.essence.base.d05_Collection;

import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet可以确保集合元素处于排序状态。TreeSet支持两种排序方式，自然排序和定制排序。
  *  其中自然排序为默认的排序方式。
    当我们构造TreeSet时，若使用不带参数的构造函数，则TreeSet的使用自然比较器；
    若用户需要使用自定义的比较器，则需要使用带比较器的参数。*/

public class TestTreeSetCompara {
	public static void main(String[] args) {

		Set<Student> set = new TreeSet<Student>();
		set.add(new Student("Justin", 96));
		set.add(new Student("Bush", 88));
		set.add(new Student("Momor", 93));
		System.out.println(set);
	}

}

class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	public int compareTo(Student other) {
		return this.score - other.score;
	}
}
