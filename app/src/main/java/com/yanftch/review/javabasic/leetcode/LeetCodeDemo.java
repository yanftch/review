package com.yanftch.review.javabasic.leetcode;

/**
 *
 */
public class LeetCodeDemo {


    public static void main(String[] args) {

    }

    /**
     * 反转链表
     */
    private static Node reverseList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node reverse = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reverse;
    }
}
