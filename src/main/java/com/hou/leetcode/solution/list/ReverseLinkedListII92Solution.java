package com.hou.leetcode.solution.list;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-26 17:57
 */
public class ReverseLinkedListII92Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i=1;
        ListNode lHead = null;
        ListNode rhead = null;
        ListNode node = head;
        ListNode pre = null;
        while (i <= n) {
            if (i == m) {
                lHead = pre;
            } else if (i == n) {
                rhead = node.next;
                node.next = null;
            }
            pre = node;
            node = node.next;
            i++;
        }

        ListNode newhead = rotate(lHead.next);
        lHead.next.next = rhead;
        lHead.next = newhead;
        return head;
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
        ReverseLinkedListII92Solution solution = new ReverseLinkedListII92Solution();
        ListNode newhead = solution.reverseBetween(head, 1, 4);
        System.out.println();
    }
}
