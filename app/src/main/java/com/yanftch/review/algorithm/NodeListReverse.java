package com.yanftch.review.algorithm;

import androidx.annotation.NonNull;

/**
 * User : yanftch
 * Date : 2019-11-27
 * Time : 18:19
 * Desc : 单链表反转
 */
public class NodeListReverse {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        System.out.println(a);
        Node reverse = reverse(a);
        System.out.println(reverse);
    }

    private static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node nextNode = head.getNext();
        Node reverse = reverse(nextNode);
        head.getNext().setNext(head);
        head.setNext(null);
        return reverse;
    }

    // 表示某一个结点
    public static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        public int getData() {
            return data;
        }

        public Node setData(int data) {
            this.data = data;
            return this;
        }

        @NonNull
        @Override
        public String toString() {
            return "data=" + data + "-->" + next;
        }
    }

    class Jiedian {
        Jiedian next;
        Object data;

    }
}
