package com.hou.leetcode.solution.list;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-26 11:16
 */
public class InsertionSortList147Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = head.next;
        newHead.next.next = null;
        while (curr != null) {
            ListNode pre = newHead;
            while (pre.next != null && curr.val > pre.next.val) {
                pre = pre.next;
            }
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node = new ListNode(4);
        head.next = node;
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next=node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        InsertionSortList147Solution solution = new InsertionSortList147Solution();
        ListNode res = solution.insertionSortList(head);
        System.out.println();
    }
}
