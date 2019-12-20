package com.hou.leetcode.solution.list;

public class RotateList {
    public ListNode rotateRight(ListNode head) {
        if (head == null)
            return null;
        ListNode pre=null,curr=head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            if (next == null) {
                return pre;
            }
        }
        return null;
    }

    public ListNode rotate(ListNode node) {
        if (node.next == null)
            return node;
        ListNode newHead = rotate(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
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
        RotateList solution = new RotateList();
//        ListNode res = solution.rotateRight(head);

        ListNode res2= solution.rotate(head);
        System.out.println();
    }
}
