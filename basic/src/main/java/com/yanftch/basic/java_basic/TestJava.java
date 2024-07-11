package com.yanftch.basic.java_basic;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestJava {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        LinkedList<String> linkedList1 = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            arrayList1.add("arr-item" + i);
            linkedList1.add("link-item" + i);
        }
        long arrTimeStart = System.currentTimeMillis();
        System.out.println(arrTimeStart);
        arrayList1.remove(5000000);
        System.out.println("ArrayList移除第一个元素耗时：" + (System.currentTimeMillis() - arrTimeStart));

        long arrTimeStart2 = System.currentTimeMillis();
        linkedList1.remove(5000000);
        System.out.println("LinkedList移除第一个元素耗时：" + (System.currentTimeMillis() - arrTimeStart2));


    }
}
