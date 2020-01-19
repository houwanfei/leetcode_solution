package com.hou.leetcode.solution.list;

/**
 * @Description 核心思想：利用前后对比跳过重复的元素
 * @auther houwf
 * @create 2020-01-19 10:36
 */
public class RemoveDuplicatesSortedListII82Solution {
    /**
     * 初始版本
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode newCurr = null;
        ListNode curr = head;
        ListNode pre = null;
        int num = 0;
        while (curr != null) {
            if (pre != null && curr.val != pre.val && num == 1) {
                pre.next = null;
                if (newHead == null) {
                    newHead = pre;
                    newCurr = pre;
                } else {
                    newCurr.next = pre;
                    newCurr = newCurr.next;
                }
                num = 1;
            } else {
                if (pre != null && pre.val != curr.val) {
                    num = 1;
                } else {
                    num++;
                }
            }
            pre = curr;
            curr = curr.next;
        }
        if (num == 1){
            if (newHead == null) {
                newHead = pre;
            } else {
                newCurr.next = pre;
            }
        }
        return newHead;
    }

    /**
     * 优化版本
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                if (pre == null) {
                    head = curr;
                } else {
                    pre.next = curr;
                }
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        RemoveDuplicatesSortedListII82Solution sortedListII82Solution = new RemoveDuplicatesSortedListII82Solution();
        ListNode res = sortedListII82Solution.deleteDuplicates2(head);
        System.out.println();
    }
}
