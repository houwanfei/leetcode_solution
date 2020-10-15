package com.hou.leetcode.solution.list;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-14 17:47
 */
public class SwapNodesPairs24Solution {
    public ListNode swapPairs(ListNode head) {
        if (head ==null || head.next == null) {
            return head;
        }
        ListNode nextStart = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextStart);
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
        SwapNodesPairs24Solution solution = new SwapNodesPairs24Solution();
        ListNode res = solution.swapPairs(head);
        System.out.println();
    }
}
