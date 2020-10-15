package com.hou.leetcode.solution.list;


import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-14 16:11
 */
public class ReverseNodesKGroup25Solution {

    /**
     * 递归分组 分别反转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for (int i=0; i<k; i++) {
            if (node == null) {
                return head;
            }
            node = node.next;
        }
        ListNode newHead = reverse(head, node);
        head.next = reverseKGroup(node, k);
        return newHead;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode head = end;
        while (start != end) {
            ListNode tmp = start.next;
            start.next = head;
            head = start;
            start = tmp;
        }
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
        ReverseNodesKGroup25Solution solution = new ReverseNodesKGroup25Solution();
        ListNode res = solution.reverseKGroup(head, 3);
        System.out.println();
    }
}
