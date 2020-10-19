package com.hou.leetcode.solution.list;


/**
 * @Description
 * @auther houwf
 * @create 2020-10-15 9:51
 */
public class ReorderList143Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        slow.next = null;
        ListNode node = head;
        while (newHead != null) {
            ListNode tmp = newHead.next;
            if (node.next == null) {
                node.next = newHead;
                break;
            }
            newHead.next = node.next;
            node.next = newHead;
            node = node.next.next;
            newHead = tmp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReorderList143Solution solution = new ReorderList143Solution();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
        solution.reorderList(head);
        System.out.println();
    }
}
