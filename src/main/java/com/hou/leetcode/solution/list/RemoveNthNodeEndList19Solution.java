package com.hou.leetcode.solution.list;

import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-24 11:13
 */
public class RemoveNthNodeEndList19Solution {
    ListNode head = null;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.head = head;
        findNthEnd(head, head, n);
        return this.head;
    }

    private int findNthEnd(ListNode preNode, ListNode node, int n) {
        if (node == null) {
            return 1;
        }
        int nth = findNthEnd(node, node.next, n);
        if (nth == n) {
            if (head == node) {
                this.head = node.next;
                node.next = null;
            }
            preNode.next = node.next;
            node.next = null;
        }
        return nth+1;
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

        RemoveNthNodeEndList19Solution solution = new RemoveNthNodeEndList19Solution();
        ListNode res = solution.removeNthFromEnd(head, 1);
        System.out.println();
    }
}
