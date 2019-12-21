package com.hou.leetcode.solution.list;

public class RemoveDuplicatesSortedList83Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            if (pre != null && pre.val == curr.val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;

        RemoveDuplicatesSortedList83Solution solution = new RemoveDuplicatesSortedList83Solution();
        ListNode res = solution.deleteDuplicates(head);
        System.out.println();
    }
}
