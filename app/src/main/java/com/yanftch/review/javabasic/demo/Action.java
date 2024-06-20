package com.yanftch.review.javabasic.demo;

public class Action<T> {
    private T item;

    public Action(T t) {
        item = t;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public static <E> void getSex(E e) {
        System.out.println("getSex--->" + e);
    }
}
