package com.yanftch.review.algorithm.jianzhi;

/**
 * User : yanftch
 * Date : 2019-12-04
 * Time : 20:21
 * Desc : 链表的结点类
 */
public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode() {
    }

    public int getData() {
        return data;
    }

    public ListNode setData(int data) {
        this.data = data;
        return this;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
