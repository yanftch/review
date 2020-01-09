package com.yanftch.review.algorithm.jianzhi;

/**
 * User : yanftch
 * Date : 2019-12-04
 * Time : 20:20
 * Desc : 两个链表的交叉结点,也就是找两个链表的第一个公共结点，如果找到，就直接返回，没有找到，返回 null
 */
public class LianBiaoJiaoCha {

    public static void main(String[] args) {
        test1();

    }

    private static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getListNodeLength(head1);
        int length2 = getListNodeLength(head2);

        int diff = length1 - length2;
        ListNode longListHead = head1;
        ListNode shortListHead = head2;

        if (diff < 0) {
            longListHead = head2;
            shortListHead = head1;
            diff = length2 - length1;
        }

        for (int i = 0; i < diff; i++) {
            longListHead = longListHead.next;
        }

        while (longListHead != null && shortListHead != null && longListHead != shortListHead) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        // 返回第一个相同的公共结点，如果没有返回null
        return longListHead;
    }

    /**
     * 获取链表的长度
     */
    private static int getListNodeLength(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.getNext();
        }
        return result;
    }

    private static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;
        System.out.println("链表 1=======> " + n1);
        System.out.println("链表 1====长度===> " + getListNodeLength(n1));
        System.out.println("======第一个交叉的结点是===> " + findFirstCommonNode(n1, n4).data);
    }
}
