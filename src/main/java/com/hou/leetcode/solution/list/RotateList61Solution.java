package com.hou.leetcode.solution.list;


public class RotateList61Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //求链表长度
        ListNode p = head;
        int len = 0;
        ListNode last = head;
        while (p != null) {
            last = p;
            p = p.next;
            len++;
        }
        k %= len;
        p = head;
        int n=0;
        while ( p != null && ++n < (len-k)) {
            p = p.next;
        }
        last.next = head;
        head = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;

        RotateList61Solution solution = new RotateList61Solution();
        ListNode res = solution.rotateRight(head, 2);
        System.out.println();
    }
}
