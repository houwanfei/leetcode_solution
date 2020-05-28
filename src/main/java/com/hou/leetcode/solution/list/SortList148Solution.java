package com.hou.leetcode.solution.list;



/**
 * @Description
 * @auther houwf
 * @create 2020-05-26 9:48
 */
public class SortList148Solution {
    /**
     * 快速排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = null;
        ListNode right = head.next;
        ListNode pre = head;
        while (right != null) {
            if (right.val < head.val) {
                pre.next = right.next;
                right.next = left;
                left = right;
                right = pre.next;
            } else {
                pre = right;
                right = right.next;
            }
        }
        head.next = sortList(head.next);
        ListNode newHead = sortList(left);
        if (newHead == null) {
            return head;
        }
        ListNode last = newHead;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        return newHead;
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

        SortList148Solution sortList148Solution = new SortList148Solution();
        ListNode res = sortList148Solution.sortList(head);
        System.out.println();
    }
}
