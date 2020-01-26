package com.essence.base.d05_Collection;

import java.util.*;

/*
 * Queue接口定义了队列相关行为。
  * 与Stack的区别在于, Stack的删除与添加都在队尾进行, 而Queue删除在队头, 添加在队尾。*/
public class TestPriorityQueue {
    public static void main(String[] args) {
        Queue<String> q = new PriorityQueue<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // null,因为队列为空
    }
}